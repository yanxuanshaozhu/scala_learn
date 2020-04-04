package pers.yanxuanshaozhu.for_expr.file_match

import java.io.File

object FileMatch {
  def main(args: Array[String]): Unit = {
    val files:Array[File] = new File("D:\\MyWork\\Java\\bigData-191122\\scala-191122\\src\\main\\scala\\pers\\yanxuanshaozhu\\for_expr\\file_match").listFiles
    for{file <- files
        if file.isFile
        if file.getName.startsWith("a")
        lines = scala.io.Source.fromFile(file).getLines().toList
        line <- lines
        length = line.trim.length}  println(line + "   " + length + " characters")
  }
}

