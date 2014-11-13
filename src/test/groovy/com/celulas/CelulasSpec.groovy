package com.celulas

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: pinky
 * Date: 11/13/14
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
class CelulasSpec extends Specification{

    void "must create a file"(){
        setup:
          Celulas celulas = new Celulas()
        when:
          def response = celulas.creaArchivo()
        then:
          assert response instanceof File

    }

    void "must find a  input file"() {
        setup:
          Celulas celulas = new Celulas()
          File file = new File("input.txt")
        when:
         def response = celulas.findFile(file)
        then:
          assert response == true
//        file.delete()
    }

    void "must dont find a  input file"() {
        setup:
        Celulas celulas = new Celulas()
        File file = new File("another.txt")
        when:
        def response = celulas.findFile(file)
        then:
        assert response == false
        file.delete()
    }

    void "must open a file"(){
        setup:
        Celulas celulas = new Celulas()
        when:
        def response = celulas.leeArchivo()
        then:
        assert response == ['.........*', '.*.*...*..', '..........', '..*.*....*', '.*..*...*.', '.........*','..........' , '.....*..*.', '.*....*...', '.....**...']

    }


}
