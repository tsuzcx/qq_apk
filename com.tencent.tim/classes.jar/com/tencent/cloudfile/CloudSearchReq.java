package com.tencent.cloudfile;

import java.util.List;

public class CloudSearchReq
{
  public int count;
  public int fileTypeFilter;
  public int modelTypeFilter;
  public byte[] pDirKey;
  public byte[] pDirKeyExclude;
  public int searchStoreBizTypeFileter;
  public int searchTransferTypeFilter;
  public List<Long> searchUinList;
  public String strKeywords;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.cloudfile.CloudSearchReq
 * JD-Core Version:    0.7.0.1
 */