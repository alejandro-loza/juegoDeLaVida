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
    }


    def  obtenArchivo() {
        def myFileName = "input.txt"
        def myFile = new File(myFileName)
        if(!myFile.exists()){
           creaArchivo(myFile)
        }  else {
            myFile
        }

    }


    File creaArchivo(File myFile) {
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

    def leeArchivo(File file) {
      file.readLines()
    }

    def inicio() {
      File archivo = obtenArchivo()
      def out =leeArchivo(archivo)
      println "ESTADO INICIAL"
      out.each {println it}     //todo imprimir salida con ciclos
      println "SIGUIENTE ESTADO"
      archivo.delete()
    }

    def holdInMatrix(List<String> strings) {
        String[][] matrix = strings as  String [][]
        matrix
    }

    def siguenteGeneracion(String[][] strings) {
        String[][] nextMatrix
         strings.eachWithIndex { row, int i ->
              row.eachWithIndex { col, int j ->
                 println row[j]
              }
        }


     }

    def encuentraVecinos(int x, int y , int lenght , int size) {
         def NORTHWEST = [:]
         def NORTH  =[:]
         def NORTHEAST = [:]
         def WEST =  [:]
         def EAST =  [:]
         def SOUTHWEST = [:]
         def SOUTH  =  [:]
         def SOUTHEAST = [:]

        if(x == 0 ){
          NORTH = NORTHWEST = NORTHEAST = null


        }
        if (y == 0){
            NORTHWEST = WEST = SOUTHWEST = null
        }

    }
}
