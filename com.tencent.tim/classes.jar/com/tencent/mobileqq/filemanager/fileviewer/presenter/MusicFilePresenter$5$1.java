package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import agrt;
import agwh;
import agxv;

class MusicFilePresenter$5$1
  implements Runnable
{
  MusicFilePresenter$5$1(MusicFilePresenter.5 param5) {}
  
  public void run()
  {
    if ((this.a.this$0.jdField_a_of_type_Agrt != null) && (this.a.this$0.jdField_a_of_type_Agrt.mD(agwh.a(this.a.this$0))))
    {
      int i = this.a.this$0.jdField_a_of_type_Agrt.getCurrentPosition();
      this.a.this$0.OB(i);
      this.a.this$0.jdField_a_of_type_Agxv.OL(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5.1
 * JD-Core Version:    0.7.0.1
 */