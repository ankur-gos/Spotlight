'''
server.py
Ankur Goswami, agoswam3@ucsc.edu
Basic page server
'''

from flask import Flask
from flask import render_template
app = Flask(__name__)

@app.route("/")
def index():
    return render_template('index.html')

if __name__ == "__main__":
    app.run()