package com.tencent.wcdb.database;

public class SQLiteCipherSpec
{
  public static final String CIPHER_AES256CBC = "aes-256-cbc";
  public static final String CIPHER_DEVLOCK = "devlock";
  public static final String CIPHER_XXTEA = "xxtea";
  public String cipher;
  public boolean hmacEnabled = true;
  public int kdfIteration;
  public int pageSize = SQLiteGlobal.a;
  
  public SQLiteCipherSpec() {}
  
  public SQLiteCipherSpec(SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    this.cipher = paramSQLiteCipherSpec.cipher;
    this.kdfIteration = paramSQLiteCipherSpec.kdfIteration;
    this.hmacEnabled = paramSQLiteCipherSpec.hmacEnabled;
    this.pageSize = paramSQLiteCipherSpec.pageSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCipherSpec
 * JD-Core Version:    0.7.0.1
 */