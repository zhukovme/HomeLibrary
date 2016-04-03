/**
 * @author Michael Zhukov
 */
var booksVM = function () {
    var self = this;

    self.books = ko.observableArray();

    self.headers = [
        {header: 'Title', sortPropertyName: 'title', asc: true},
        {header: 'Author', sortPropertyName: 'author', asc: true}
    ];

    self.activeSort = self.headers[0];
    self.sort = function (header, event) {
        if (self.activeSort === header) {
            header.asc = !header.asc;
        } else {
            self.activeSort = header;
        }
        var prop = self.activeSort.sortPropertyName;
        var ascSort = function (a, b) {
            return a[prop] < b[prop] ? -1 : a[prop] > b[prop] ? 1 : a[prop] == b[prop] ? 0 : 0;
        };
        var descSort = function (a, b) {
            return ascSort(b, a);
        };
        var sortFunc = self.activeSort.asc ? ascSort : descSort;
        self.books.sort(sortFunc);
    };

    self.showBook = function () {
        window.open("/show-book.html?id=" + this.id, "_self");
    };

    var req = new XMLHttpRequest();
    var url = "/json/books";
    req.onreadystatechange = function () {
        if (req.status == 200) {
            self.books(JSON.parse(req.responseText));
        }
    };
    req.open("GET", url, true);
    req.send();
};

ko.applyBindings(new booksVM());
