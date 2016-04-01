/**
 * @author Michael Zhukov
 */
var booksVM = function() {
    var self = this;

    self.books = ko.observableArray();

    var req = new XMLHttpRequest();
    var url = "/json/books";
    req.onreadystatechange = function() {
        if (req.status == 200) {
            self.books(JSON.parse(req.responseText));
        }
    };
    req.open("GET", url, true);
    req.send();
};

ko.applyBindings(new booksVM());
