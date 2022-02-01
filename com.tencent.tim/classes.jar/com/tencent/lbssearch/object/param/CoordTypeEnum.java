package com.tencent.lbssearch.object.param;

public enum CoordTypeEnum
{
  public TranslateParam.CoordType coordType;
  
  static
  {
    GPS = new CoordTypeEnum("GPS", 1, TranslateParam.CoordType.GPS);
    SOGOU = new CoordTypeEnum("SOGOU", 2, TranslateParam.CoordType.SOGOU);
    BAIDU = new CoordTypeEnum("BAIDU", 3, TranslateParam.CoordType.BAIDU);
    MAPBAR = new CoordTypeEnum("MAPBAR", 4, TranslateParam.CoordType.MAPBAR);
  }
  
  private CoordTypeEnum(TranslateParam.CoordType paramCoordType)
  {
    this.coordType = paramCoordType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.CoordTypeEnum
 * JD-Core Version:    0.7.0.1
 */