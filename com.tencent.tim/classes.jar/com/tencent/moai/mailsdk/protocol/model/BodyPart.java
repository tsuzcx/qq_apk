package com.tencent.moai.mailsdk.protocol.model;

import com.tencent.moai.mailsdk.protocol.datasource.DataSource;

public abstract class BodyPart
  implements Part
{
  public abstract DataSource getDataSource();
  
  public abstract void setDataSource(DataSource paramDataSource);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.model.BodyPart
 * JD-Core Version:    0.7.0.1
 */