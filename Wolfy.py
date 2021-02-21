import sys
from PyQt5.QtCore import *
from PyQt5.QtWidgets import *
from PyQt5.QtWebEngineWidgets import *


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.browser = QWebEngineView()
        self.browser.setUrl(QUrl('https://google.com'))
        self.setCentralWidget(self.browser)
        self.showMaximized()

        #navigation bar
        navbar=QToolBar()
        self.addToolBar(navbar)

        #Back button
        back_btn=QAction("<-",self)
        back_btn.triggered.connect(self.browser.back)
        navbar.addAction(back_btn)

        #Forward Button
        for_btn=QAction("->",self)
        for_btn.triggered.connect(self.browser.forward)
        navbar.addAction(for_btn)

        #Reload button
        reload_btn=QAction("@",self)
        reload_btn.triggered.connect(self.browser.reload)
        navbar.addAction(reload_btn)

        #home button
        home_btn=QAction("^",self)
        home_btn.triggered.connect(self.navigate_home)
        navbar.addAction(home_btn)

        #URL Bar
        self.url_bar=QLineEdit()
        self.url_bar.returnPressed.connect(self.navigate_to_url)
        navbar.addWidget(self.url_bar)

        #url change
        self.browser.urlChanged.connect(self.update_url)

    def navigate_home(self):
        self.browser.setUrl(QUrl("https://google.com"))

    def navigate_to_url(self):
        url=self.url_bar.text()
        self.browser.setUrl(QUrl(url))

    def update_url(self,new_url):
        self.url_bar.setText(new_url.toString())



My_app = QApplication(sys.argv)
QApplication.setApplicationName("Wolfy")
window = MainWindow()
My_app.exec()
