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

    def File obtenArchivo() {
        def myFileName = "input.txt"
        def myFile = new File(myFileName)
        myFile
    }


    def creaArchivo() {
      File myFile = obtenArchivo()
      myFile << '.........*\n'
      myFile << '.*.*...*..\n'
      myFile << '..........\n'
      myFile <<'..*.*....*\n'
      myFile <<'.*..*...*.\n'
      myFile <<'.........*\n'
      myFile << '..........\n'
      myFile <<'.....*..*.\n'
      myFile << '.*....*...\n'
      myFile << '.....**...'

      myFile
    }


    boolean findFile(File file) {
         file
        if (!file.createNewFile()) {
            assert file.exists()
            true
        }
        else  false
    }

    def leeArchivo() {
      obtenArchivo().readLines()
    }
}
