package com.tencent.moai.database.sqlite;

import java.io.File;
import java.io.FileFilter;

final class SQLiteDatabase$2
  implements FileFilter
{
  SQLiteDatabase$2(String paramString) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().startsWith(this.val$prefix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteDatabase.2
 * JD-Core Version:    0.7.0.1
 */