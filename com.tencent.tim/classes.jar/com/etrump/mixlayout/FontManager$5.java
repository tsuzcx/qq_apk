package com.etrump.mixlayout;

import android.graphics.Typeface;
import aqiw;
import aqnl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import h;
import i;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kt;
import ku;

public class FontManager$5
  implements Runnable
{
  public FontManager$5(ku paramku, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean) {}
  
  public void run()
  {
    if (ku.j.get(Integer.valueOf(this.iI)) != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "asyncLoadFont font " + this.iI + " has loaded");
      }
    }
    label298:
    label444:
    label481:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = ku.e(this.iI, this.iJ);
            if (!new File((String)localObject).exists()) {
              break label602;
            }
            localObject = new kt(this.iI, (String)localObject);
            ((kt)localObject).mFontType = this.iJ;
            if (this.iJ == 0) {
              ((kt)localObject).mFontType = 1;
            }
            switch (this.iJ)
            {
            default: 
              return;
            case 1: 
              if (!ETEngine.getInstance().isEngineInited.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.e("VasFont", 2, "doGetUserFont and fontEngine not init");
                }
                this.this$0.eS();
              }
              if (!ETEngine.getInstance().isEngineReady.get()) {
                break label481;
              }
              if (this.this$0.mEngine != null) {
                break label298;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("VasFont", 2, "doGetUserFont mEngine = null");
          return;
          try
          {
            ((kt)localObject).mTypeface = Typeface.createFromFile(((kt)localObject).mFontPath);
            ku.j.put(Integer.valueOf(this.iI), localObject);
            aqnl.H(this.this$0.mApp);
            ku.a(this.this$0);
            return;
          }
          catch (Exception localException)
          {
            QLog.e("VasFont", 1, "getFontInfo createTypeface error: " + localException.getMessage());
            ((kt)localObject).mTypeface = null;
            return;
          }
          if ((this.this$0.mEngine.native_isFontLoaded(this.iI)) && (this.this$0.a.native_isFontLoaded(this.iI))) {
            break label444;
          }
          if (this.this$0.a((kt)localObject, this.val$uin, this.iK)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("VasFont", 2, "doGetUserFont setActiveFont fail");
        return;
        ETFont localETFont = new ETFont(((kt)localObject).mFontId, ((kt)localObject).mFontPath, 1.0F);
        ((kt)localObject).iB = this.this$0.mEngine.native_getVariantStyleComboCount(localETFont);
        if (QLog.isColorLevel()) {
          QLog.i("VasFont", 2, "asyncLoadFont: id=" + ((kt)localObject).mFontId + " styleCount=" + ((kt)localObject).iB);
        }
        ku.cA = true;
        ku.j.put(Integer.valueOf(this.iI), localObject);
        aqnl.H(this.this$0.mApp);
        ku.a(this.this$0);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("VasFont", 2, "doGetUserFont fontEngine not init mIsFontEngineReady = " + ETEngine.getInstance().isEngineReady.get() + " mIsFontEngineInited = " + ETEngine.getInstance().isEngineInited.get());
      return;
      i.a().b(this.iI, ((kt)localObject).mFontPath);
      ((kt)localObject).iB = h.l(this.iI);
      ((kt)localObject).mFontType = 4;
      ku.j.put(Integer.valueOf(this.iI), localObject);
      aqnl.H(this.this$0.mApp);
      ku.a(this.this$0);
      return;
      if ((this.this$0.mApp.getCurrentAccountUin().equals(this.val$uin)) || (!this.cH) || (aqiw.isWifiConnected(this.this$0.mApp.getApplication())) || (aqiw.is3Gor4G(this.this$0.mApp.getApplication()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    label602:
    QLog.e("VasFont", 2, "getFontInfo isTroopOrDiscussion but no wifi or 3G 4G.");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "getFontInfo startDownload no cache");
    }
    this.this$0.b(this.iI, null, this.iJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.5
 * JD-Core Version:    0.7.0.1
 */