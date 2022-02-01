package com.tencent.mobileqq.hiboom;

import ahxo;
import ahxo.a;
import ahxp;
import ahxq;
import android.graphics.Typeface;
import android.text.TextUtils;
import aqhq;
import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import i;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class HiBoomFontDrawer$1
  implements Runnable
{
  public HiBoomFontDrawer$1(ahxp paramahxp, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.mType = this.this$0.B(this.cI);
    Object localObject;
    boolean bool1;
    if ((this.this$0.mType == 1) || (this.this$0.mType == 3))
    {
      if (!ahxo.a().I.get()) {
        ahxo.a().dqH();
      }
      if (ahxo.a().H.get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.FontDrawer", 2, "initHiBoomInfo HYEngine Ready");
        }
        localObject = ".hy3";
        if (this.this$0.mType == 1) {
          localObject = ".hy";
        }
        localObject = this.this$0.jdField_a_of_type_Ahxo$a.getFontPath() + this.this$0.mFontId + File.separator + this.this$0.mFontId + (String)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.FontDrawer", 2, "initHiboom: path= " + (String)localObject + " fontId=" + this.this$0.mFontId);
        }
        if (!new File((String)localObject).exists()) {
          break label371;
        }
        boolean bool2 = ahxo.a().e.native_isFontLoaded(this.this$0.mFontId);
        boolean bool3 = ahxo.a().f.native_isFontLoaded(this.this$0.mFontId);
        bool1 = bool2;
        if (!bool2) {
          bool1 = ahxo.a().e.native_loadFont((String)localObject, this.this$0.mFontId, false);
        }
        bool2 = bool3;
        if (!bool3) {
          bool2 = ahxo.a().f.native_loadFont((String)localObject, this.this$0.mFontId, false);
        }
        localObject = this.this$0.cX;
        if ((!bool1) || (!bool2)) {
          break label366;
        }
        bool1 = true;
        ((AtomicBoolean)localObject).set(bool1);
      }
    }
    label686:
    for (;;)
    {
      if (this.this$0.cX.get()) {
        ahxp.a(this.this$0);
      }
      this.this$0.cY.set(false);
      return;
      label366:
      bool1 = false;
      break;
      label371:
      if (this.cI)
      {
        this.this$0.cZ.set(false);
        this.this$0.jdField_a_of_type_Ahxo$a.Pw(this.this$0.mFontId);
        continue;
        if (this.this$0.mType == 2)
        {
          localObject = new File(this.this$0.jdField_a_of_type_Ahxo$a.getFontPath() + this.this$0.mFontId + File.separator + this.this$0.mFontId + ".hb");
          String str = aqhq.b((File)localObject, -1);
          if (!TextUtils.isEmpty(str))
          {
            this.this$0.jdField_a_of_type_Ahxq = ahxq.a(str);
            if (this.this$0.k == null)
            {
              localObject = this.this$0.jdField_a_of_type_Ahxo$a.getFontPath() + this.this$0.mFontId + File.separator + this.this$0.mFontId + ".fz";
              if (!aqhq.fileExists((String)localObject)) {
                break label686;
              }
            }
            for (;;)
            {
              try
              {
                this.this$0.k = Typeface.createFromFile((String)localObject);
                this.this$0.cX.set(true);
              }
              catch (Exception localException)
              {
                QLog.e("HiBoomFont.FontDrawer", 2, "file error:" + (String)localObject, localException);
                aqhq.cn(this.this$0.jdField_a_of_type_Ahxo$a.getFontPath() + this.this$0.mFontId);
                return;
              }
              QLog.e("HiBoomFont.FontDrawer", 2, "file is not exist, path=" + (String)localObject);
            }
          }
          if ((!((File)localObject).exists()) && (this.cI))
          {
            this.this$0.cZ.set(false);
            this.this$0.jdField_a_of_type_Ahxo$a.Pw(this.this$0.mFontId);
          }
        }
        else if (this.this$0.mType == 4)
        {
          if (!i.a().n.get())
          {
            ahxo.a().dqI();
            QLog.d("HiBoomFont.FontDrawer", 2, "run: initFZEngine");
          }
          if (i.a().p.get())
          {
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.FontDrawer", 2, "initHiBoomInfo: initFont");
            }
            ThreadManager.getUIHandler().post(new HiBoomFontDrawer.1.1(this));
          }
          else
          {
            this.this$0.cY.set(false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.1
 * JD-Core Version:    0.7.0.1
 */