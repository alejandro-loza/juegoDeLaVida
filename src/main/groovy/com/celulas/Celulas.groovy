package com.celulas

/**
 * Created with IntelliJ IDEA.
 * User: pinky
 * Date: 11/12/14
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
class Celulas {
    def main(String[] args){
        imprime()
    }

    def imprime() {
      println  'Hola mundo'
    }

    def creaArchivo() {
       def directory = "/file"
       def  myFileName = "input.txt"
       def  myFile = new File(directory + myFileName).createNewFile()



                '.........*\n' +
                '.*.*...*..\n' +
                '..........\n' +
                '..*.*....*\n' +
                '.*..*...*.\n' +
                '.........*\n' +
                '..........\n' +
                '.....*..*.\n' +
                '.*....*...\n' +
                '.....**...'



    }
}
