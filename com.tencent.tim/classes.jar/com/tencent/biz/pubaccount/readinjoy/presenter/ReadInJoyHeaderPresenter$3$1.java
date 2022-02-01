package com.tencent.biz.pubaccount.readinjoy.presenter;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import lie;
import lko;
import lks;
import ndi;

public class ReadInJoyHeaderPresenter$3$1
  implements Runnable
{
  public ReadInJoyHeaderPresenter$3$1(lks paramlks) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.kL.size())
    {
      localArrayList.add(((lie)this.a.kL.get(i)).a());
      i += 1;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("headerUninterestConfirm,");
      if (this.a.kM != null) {
        break label139;
      }
    }
    label139:
    for (String str = "null";; str = this.a.kM.toString())
    {
      QLog.d("ReadInJoyHeaderPresenter", 2, str);
      lko.a(this.a.a).a(this.a.aPu, localArrayList, this.a.kM, this.a.val$object);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyHeaderPresenter.3.1
 * JD-Core Version:    0.7.0.1
 */