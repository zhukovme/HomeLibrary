/**
* @author Michael Zhukov
*/
function BookVM() {
    var self = this;

    self.title = ko.observable();
    self.date = ko.observable();
    self.author = ko.observable();
    self.isbn = ko.observable();

    var req = new XMLHttpRequest();
    var id = window.location.search.split("=")[1];
    var url = "/json/book/" + id;
    req.onreadystatechange = function () {
        if (req.status == 200) {
            var book = JSON.parse(req.responseText);
            self.title(book.title);
            self.date(book.date);
            self.author(book.author);
            self.isbn(book.isbn);
        }
    };
    req.open("GET", url, true);
    req.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    req.send();
}

ko.applyBindings(new BookVM());
