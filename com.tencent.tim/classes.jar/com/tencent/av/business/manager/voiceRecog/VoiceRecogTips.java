package com.tencent.av.business.manager.voiceRecog;

import acfp;
import anaz;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.ui.QavListItemBase.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import iiu;
import iiv;
import ijv;
import ijv.a;
import ijv.b;
import ila;
import ilb;
import irk;
import iwu;

public class VoiceRecogTips
{
  static int aor = -1;
  static long lF;
  static long lG = -1L;
  ShowTipsRunable a;
  String mPeerUin;
  
  public VoiceRecogTips(VideoAppInterface paramVideoAppInterface, String paramString, ijv.a parama)
  {
    this.mPeerUin = paramString;
    a(paramVideoAppInterface, parama);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt, HorizontalListView paramHorizontalListView)
  {
    int i;
    if (3 != paramInt)
    {
      paramInt = 0;
      i = 1;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("VoiceRecogTips", 1, "tryShowVoiceStickerTabTips, ret[" + i + "], count[" + paramInt + "]");
      }
      return;
      if (paramVideoAppInterface == null)
      {
        i = 10;
        paramInt = 0;
      }
      else if (paramHorizontalListView == null)
      {
        paramInt = 0;
        i = 2;
      }
      else
      {
        iiv localiiv = paramVideoAppInterface.b().b();
        if (localiiv == null)
        {
          i = 11;
          paramInt = 0;
        }
        else
        {
          ijv.b localb = ((ijv)paramVideoAppInterface.a(3)).a();
          if (localb == null)
          {
            i = 12;
            paramInt = 0;
          }
          else if (e(paramVideoAppInterface))
          {
            paramInt = 0;
            i = 13;
          }
          else
          {
            paramInt = localiiv.a().amG;
            if (localiiv.a().amG == 2147483647)
            {
              i = 13;
            }
            else
            {
              Object localObject = localiiv.a();
              ((iiu)localObject).amG += 1;
              if (localiiv.a().amG < localb.anS)
              {
                i = 15;
              }
              else if (!ila.c(paramVideoAppInterface))
              {
                i = 20;
              }
              else if (!irk.a().isEnable())
              {
                i = 21;
              }
              else if (irk.a().cr(2))
              {
                i = 22;
              }
              else
              {
                localObject = paramHorizontalListView.getAdapter();
                if (localObject == null)
                {
                  i = 3;
                }
                else
                {
                  int j = paramHorizontalListView.getFirstVisiblePosition();
                  i = j;
                  if (j == 0) {
                    i = j + 1;
                  }
                  paramHorizontalListView = ((ListAdapter)localObject).getItem(i);
                  if (!(paramHorizontalListView instanceof QavListItemBase.c))
                  {
                    i = 14;
                  }
                  else
                  {
                    paramHorizontalListView = (QavListItemBase.c)paramHorizontalListView;
                    if (!(paramHorizontalListView.ax instanceof FaceItem))
                    {
                      i = 14;
                    }
                    else
                    {
                      paramHorizontalListView = ((FaceItem)paramHorizontalListView.ax).getVoiceName();
                      if (TextUtils.isEmpty(paramHorizontalListView))
                      {
                        i = 16;
                      }
                      else if (iwu.a(paramVideoAppInterface, 1026, localb.dj(paramHorizontalListView), null, localb.anR, null))
                      {
                        ilb.anM();
                        f(paramVideoAppInterface);
                        localiiv.a().amG = 2147483647;
                        i = 100;
                      }
                      else
                      {
                        i = 99;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, QavListItemBase.c paramc)
  {
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    boolean bool;
    Object localObject1;
    if (paramVideoAppInterface == null)
    {
      i = 10;
      j = 0;
      localObject2 = null;
      localObject3 = null;
      paramc = null;
      bool = false;
      localObject1 = null;
      if (!bool) {
        break label604;
      }
      if (!iwu.a(paramVideoAppInterface, 1026, ((ijv.b)localObject1).dj(paramc), null, ((ijv.b)localObject1).anU, null)) {
        break label598;
      }
      i = 100;
      iiu.a(((iiv)localObject3).a(), (String)localObject2, 2147483647);
      ilb.anM();
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("VoiceRecogTips", 1, "tryShowVoiceStickerItemTips, ret[" + i + "], count[" + j + "], id[" + (String)localObject2 + "], showTipsRequest[" + bool + "]");
      }
      return;
      localObject1 = paramVideoAppInterface.b().b();
      if (localObject1 == null)
      {
        i = 11;
        localObject2 = null;
        localObject3 = localObject1;
        paramc = null;
        bool = false;
        j = 0;
        localObject1 = null;
        break;
      }
      localObject3 = (FaceItem)paramc.ax;
      localObject2 = ((ijv)paramVideoAppInterface.a(3)).a();
      if (localObject2 == null)
      {
        i = 12;
        localObject4 = null;
        paramc = null;
        bool = false;
        localObject3 = localObject1;
        j = 0;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
      }
      if (!(paramc.ax instanceof FaceItem))
      {
        i = 14;
        localObject4 = null;
        paramc = null;
        bool = false;
        localObject3 = localObject1;
        j = 0;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
      }
      paramc = ((FaceItem)localObject3).getId();
      j = iiu.a(((iiv)localObject1).a(), paramc);
      if (j == 2147483647)
      {
        i = 13;
        localObject3 = paramc;
        bool = false;
        localObject4 = localObject1;
        paramc = null;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      i = j + 1;
      iiu.a(((iiv)localObject1).a(), paramc, i);
      if (i < ((ijv.b)localObject2).anT)
      {
        k = 15;
        localObject3 = paramc;
        bool = false;
        localObject4 = localObject1;
        j = i;
        paramc = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      if (!ila.c(paramVideoAppInterface))
      {
        k = 20;
        localObject3 = paramc;
        bool = false;
        localObject4 = localObject1;
        j = i;
        paramc = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      if (!irk.a().isEnable())
      {
        k = 21;
        localObject3 = paramc;
        bool = false;
        localObject4 = localObject1;
        j = i;
        paramc = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      if (irk.a().cr(2))
      {
        k = 22;
        localObject3 = paramc;
        bool = false;
        localObject4 = localObject1;
        j = i;
        paramc = null;
        i = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
      }
      Object localObject4 = ((FaceItem)localObject3).getVoiceName();
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        k = 16;
        bool = false;
        localObject3 = localObject1;
        j = i;
        localObject1 = localObject4;
        localObject4 = paramc;
        i = k;
        paramc = (QavListItemBase.c)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
      }
      int k = 0;
      bool = true;
      localObject3 = localObject1;
      j = i;
      localObject1 = localObject4;
      localObject4 = paramc;
      i = k;
      paramc = (QavListItemBase.c)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break;
      label598:
      i = 99;
      continue;
      label604:
      iwu.a(paramVideoAppInterface, 1026);
    }
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if (aor == -1)
    {
      paramVideoAppInterface = ila.a(paramVideoAppInterface);
      String str = paramVideoAppInterface.getString("blessingTips", null);
      long l = paramVideoAppInterface.getLong("blessingTime", 0L);
      if (!TextUtils.equals(str, paramString)) {
        break label59;
      }
      aor = 1;
      lF = l;
    }
    while (aor == 1)
    {
      return true;
      label59:
      aor = 0;
    }
    return false;
  }
  
  static void b(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    paramVideoAppInterface = ila.a(paramVideoAppInterface);
    paramVideoAppInterface.edit().putString("blessingTips", paramString);
    lF = anaz.gQ();
    paramVideoAppInterface.edit().putLong("blessingTime", lF);
    aor = 1;
  }
  
  public static void c(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    iwu.a(paramVideoAppInterface, 1025, acfp.m(2131716864) + paramString + acfp.m(2131716865));
  }
  
  public static boolean e(VideoAppInterface paramVideoAppInterface)
  {
    if (lG == -1L) {
      lG = ila.a(paramVideoAppInterface).getLong("voiceStickerTabShowFlag", 0L);
    }
    return lG > 0L;
  }
  
  public static void f(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = ila.a(paramVideoAppInterface);
    lG = anaz.gQ();
    paramVideoAppInterface.edit().putLong("voiceStickerTabShowFlag", lG);
  }
  
  void a(VideoAppInterface paramVideoAppInterface, ijv.a parama)
  {
    this.a = new ShowTipsRunable(paramVideoAppInterface, parama);
    paramVideoAppInterface.getHandler().postDelayed(this.a, parama.anP);
  }
  
  public void g(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface.getHandler().removeCallbacks(this.a);
    this.a = null;
  }
  
  static class ShowTipsRunable
    implements Runnable
  {
    ijv.a a;
    VideoAppInterface mApp;
    
    ShowTipsRunable(VideoAppInterface paramVideoAppInterface, ijv.a parama)
    {
      this.a = parama;
      this.mApp = paramVideoAppInterface;
    }
    
    public void run()
    {
      if (!irk.a().isEnable()) {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog disable");
      }
      do
      {
        return;
        if (VoiceRecogTips.a(this.mApp, this.a.id))
        {
          QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 已经显示过了, time[" + VoiceRecogTips.lF + "]");
          return;
        }
        if (irk.a().cr(2))
        {
          QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog isPause");
          return;
        }
        iiv localiiv = this.mApp.b().b();
        if (localiiv == null)
        {
          QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, sessionInfo为空");
          return;
        }
        if (!localiiv.PY)
        {
          QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 本地没开摄像头");
          return;
        }
        if (!localiiv.PZ)
        {
          QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 对端没开摄像头");
          return;
        }
      } while (!iwu.a(this.mApp, 1026, this.a.text, null, this.a.anQ, null));
      VoiceRecogTips.b(this.mApp, this.a.id);
      ilb.anN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogTips
 * JD-Core Version:    0.7.0.1
 */