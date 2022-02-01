package com.tencent.biz.qqstory.network.handler;

import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import pmi;
import psi;
import psx;
import pxl;
import pxl.b;
import pxl.c;

public class GetHotSortVideoHandler$GetHotSortVideoResponse$1
  implements Runnable
{
  public GetHotSortVideoHandler$GetHotSortVideoResponse$1(pxl.b paramb, ArrayList paramArrayList, pxl.c paramc) {}
  
  public void run()
  {
    ((psi)psx.a(25)).b(this.mN, pxl.a(this.jdField_a_of_type_Pxl$b.a), true);
    this.jdField_a_of_type_Pxl$c.list = this.mN;
    pmi.a().dispatch(this.jdField_a_of_type_Pxl$c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse.1
 * JD-Core Version:    0.7.0.1
 */