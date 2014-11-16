package com.celulas

/**
 * Created with IntelliJ IDEA.
 * User: pinky
 * Date: 11/12/14
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
class Celulas {
    public void main(String[] args) {
        inicio()
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
        List<String> input =leeArchivo(archivo)
      input.each {println it}
      String [][]iterableMatrix = holdInMatrix(input)

        def y=0
        while ( y-- > 10 ) {
  		  def out = siguenteGeneracion(iterableMatrix)
          println "out $y" + out
          iterableMatrix == siguenteGeneracion(out)
         }
     
      archivo.delete()
      iterableMatrix
    }

    def holdInMatrix(List<String> strings) {
        String[][] matrix = strings as  String [][]
        matrix
    }

    String[][] siguenteGeneracion(String[][] strings) {
        String[][] newMatrix = new String [strings.length][strings.length]
        strings.eachWithIndex { row, int i ->
              row.eachWithIndex { celula, int j ->
                 if(vive (buscaVivas(strings ,encuentraVecinos(i,j,strings.length)),status(celula))){
                     newMatrix[i][j]= "*"
                 } else  {
                     newMatrix[i][j]= "."
                 }
              }
        }
        newMatrix
     }

    def encuentraVecinos(int row, int col , int length ) {
       List vecinos = []

        int rowStart  = Math.max( row - 1, 0   )
        int rowFinish = Math.min( row + 1, length - 1 )
        int colStart  = Math.max( col - 1, 0  )
        int colFinish = Math.min( col + 1, length - 1 )

        for ( int curRow = rowStart; curRow <= rowFinish; curRow++ ) {
            for ( int curCol = colStart; curCol <= colFinish; curCol++ ) {
             if([curRow,curCol] != [row,col]){
                 vecinos << [curRow,curCol]
             }
            }
        }
        vecinos
    }

    Integer buscaVivas(String[][] matriz, List<List<Integer>> vecinos) {
       def vivas = 0
       vecinos.each { x,y->
           if(matriz[x][y] == "*"){
             vivas++
           }
       }
       vivas
    }

    def vive(Integer vivos, boolean estatus) {
        if(estatus && vivos <2){
            return false
        }
        else if(estatus && vivos in (2..3) ){
          return true
        }
        else if(!estatus && vivos == 3 ){
            return true
        }
    }

    boolean status(String original) {
        original =='*' ?: false
    }

    def convierteTexto(String[][] matrix){
        matrix.collect{
           it.join()
        }
    }


}
