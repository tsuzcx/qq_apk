package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import pxs.b;
import qmm;
import qoa;
import qob;

public class VipForwardVideoInfoController$1$1
  implements Runnable
{
  public VipForwardVideoInfoController$1$1(qob paramqob, pxs.b paramb) {}
  
  public void run()
  {
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_Pxs$b.c;
    if (localQQUserUIItem != null)
    {
      this.jdField_a_of_type_Qob.a.b.show();
      qoa.a(this.jdField_a_of_type_Qob.a, localQQUserUIItem, this.jdField_a_of_type_Qob.b);
      return;
    }
    this.jdField_a_of_type_Qob.a.b.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.VipForwardVideoInfoController.1.1
 * JD-Core Version:    0.7.0.1
 */