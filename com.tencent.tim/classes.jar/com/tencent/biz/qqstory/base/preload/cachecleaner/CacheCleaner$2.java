package com.tencent.biz.qqstory.base.preload.cachecleaner;

import pnq;
import pnq.a;
import pnr;
import pnt;
import pnu;
import pnv;
import pnw;

public class CacheCleaner$2
  implements Runnable
{
  public CacheCleaner$2(pnr parampnr, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = new pnv(pnr.bN);
    pnt localpnt = new pnt(pnr.bO);
    pnu localpnu = new pnu(pnr.bP);
    pnw localpnw = new pnw(pnr.bQ);
    localpnt.a(localpnu).a(localpnw).a((pnq)localObject);
    localObject = new pnq.a();
    ((pnq.a)localObject).aAR = this.aAS;
    ((pnq.a)localObject).startTime = System.currentTimeMillis();
    localpnt.a((pnq.a)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner.2
 * JD-Core Version:    0.7.0.1
 */