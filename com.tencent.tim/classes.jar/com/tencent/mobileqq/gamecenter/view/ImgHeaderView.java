package com.tencent.mobileqq.gamecenter.view;

import abmt;
import ahtz;
import ahua;
import ahuh;
import ahui;
import ahuj;
import ahuk;
import ahul;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anqu;
import anqv;
import ansr;
import aqrb;
import awot;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import obj;
import tbb;

public class ImgHeaderView
  extends RelativeLayout
  implements ahuh
{
  private RelativeLayout fs;
  private Button gl;
  private ImageView mCover;
  private TextView mText;
  private String mUrl;
  
  public ImgHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Activity paramActivity, MessageRecord paramMessageRecord)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", this.mUrl);
    paramActivity.startActivity(localIntent);
    paramActivity = new HashMap();
    tbb.b(paramActivity, ahtz.b(paramMessageRecord, 0));
    paramActivity.put(Integer.valueOf(2), ahtz.t(paramMessageRecord));
    paramActivity.put(Integer.valueOf(4), "20");
    tbb.a(abmt.getAppInterface(), "769", "205019", ahtz.b(paramMessageRecord, 0), "76901", "1", "160", paramActivity);
    ((aqrb)abmt.getAppInterface().getBusinessHandler(71)).X(3, paramMessageRecord.getExtInfoFromExtStr("pa_msgId"), this.mUrl);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, QQGameMsgInfo paramQQGameMsgInfo)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", this.mUrl);
    paramActivity.startActivity(localIntent);
    paramActivity = new HashMap();
    paramActivity.put(Integer.valueOf(24), "1");
    paramActivity.put(Integer.valueOf(2), paramString1);
    paramActivity.put(Integer.valueOf(4), "20");
    tbb.a(abmt.getAppInterface(), "769", "205019", paramString2, "76901", "1", "160", paramActivity);
    awot.X(3, paramString1, this.mUrl);
    try
    {
      ahua.a(102, paramQQGameMsgInfo, paramInt);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    Object localObject1 = "";
    Object localObject3;
    for (Object localObject2 = "";; localObject2 = localObject3)
    {
      int k;
      Object localObject5;
      for (;;)
      {
        int n;
        try
        {
          if ((paramMessageRecord instanceof MessageForStructing))
          {
            ArrayList localArrayList = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
            k = 0;
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (k < localArrayList.size())
            {
              localObject3 = localObject2;
              localObject5 = localObject1;
              if (!(localArrayList.get(k) instanceof anqv)) {
                break;
              }
              localObject4 = ((anqv)localArrayList.get(k)).rz;
              m = 0;
              j = 0;
              i = 0;
              if (m >= ((ArrayList)localObject4).size()) {
                break label585;
              }
              if ((((ArrayList)localObject4).get(m) instanceof StructMsgItemTitle))
              {
                localObject2 = ((StructMsgItemTitle)((ArrayList)localObject4).get(m)).text;
                i = j;
                j = 1;
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
                break label606;
                this.mUrl = ((anqu)localArrayList.get(k)).ku;
                localObject3 = localObject1;
                localObject5 = localObject4;
                if (j == 0) {
                  break;
                }
                localObject3 = localObject1;
                localObject5 = localObject4;
                if (i == 0) {
                  break;
                }
                localObject3 = localObject1;
              }
            }
            else
            {
              this.fs = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559372, this, false));
              this.mCover = ((ImageView)this.fs.findViewById(2131369002));
              localObject1 = URLDrawable.getDrawable((String)localObject4);
              this.mCover.setImageDrawable((Drawable)localObject1);
              this.mText = ((TextView)this.fs.findViewById(2131379401));
              this.mText.setText((CharSequence)localObject3);
              ((ImageView)this.fs.findViewById(2131371159)).setImageDrawable(URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412124557_I8OGtzphYZ.png"));
              this.gl = ((Button)this.fs.findViewById(2131365760));
              this.gl.setBackgroundDrawable(ahtz.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
              this.gl.setOnClickListener(new ahui(this, paramActivity, paramMessageRecord));
              this.fs.setOnClickListener(new ahuj(this, paramActivity, paramMessageRecord));
              addView(this.fs);
              return;
            }
            if ((((ArrayList)localObject4).get(m) instanceof ansr))
            {
              localObject3 = ((ansr)((ArrayList)localObject4).get(m)).aNt;
              n = 1;
              j = i;
              localObject1 = localObject2;
              localObject2 = localObject3;
              i = n;
              break label606;
            }
          }
          else
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (!(paramMessageRecord instanceof MessageForPubAccount)) {
              continue;
            }
            localObject1 = (MessageForPubAccount)paramMessageRecord;
            ((MessageForPubAccount)localObject1).mPAMessage = obj.a(((MessageForPubAccount)localObject1).msgData);
            localObject4 = ((PAMessage.Item)((MessageForPubAccount)localObject1).mPAMessage.items.get(0)).cover;
            localObject3 = ((PAMessage.Item)((MessageForPubAccount)localObject1).mPAMessage.items.get(0)).title;
            this.mUrl = ((PAMessage.Item)((MessageForPubAccount)localObject1).mPAMessage.items.get(0)).url;
            continue;
          }
          n = i;
        }
        catch (Throwable paramMessageRecord)
        {
          QLog.e("ImgHeaderView", 1, "init imgHeader failed e=" + paramMessageRecord.toString());
          return;
        }
        localObject3 = localObject1;
        int i = j;
        int j = n;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label606;
        label585:
        Object localObject4 = localObject1;
        int m = i;
        localObject1 = localObject2;
        i = j;
        j = m;
        continue;
        label606:
        if ((j != 0) && (i != 0))
        {
          localObject4 = localObject2;
        }
        else
        {
          n = m + 1;
          localObject3 = localObject2;
          m = j;
          j = i;
          i = m;
          localObject2 = localObject1;
          localObject1 = localObject3;
          m = n;
        }
      }
      k += 1;
      localObject1 = localObject5;
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    try
    {
      Object localObject = paramQQGameMsgInfo.coverUrl;
      String str = paramQQGameMsgInfo.title;
      this.mUrl = paramQQGameMsgInfo.url;
      this.fs = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559372, this, false));
      this.mCover = ((ImageView)this.fs.findViewById(2131369002));
      localObject = URLDrawable.getDrawable((String)localObject);
      this.mCover.setImageDrawable((Drawable)localObject);
      this.mText = ((TextView)this.fs.findViewById(2131379401));
      this.mText.setText(str);
      ((ImageView)this.fs.findViewById(2131371159)).setImageDrawable(URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412124557_I8OGtzphYZ.png"));
      this.gl = ((Button)this.fs.findViewById(2131365760));
      this.gl.setBackgroundDrawable(ahtz.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
      this.gl.setOnClickListener(new ahuk(this, paramActivity, paramQQGameMsgInfo, paramInt));
      this.fs.setOnClickListener(new ahul(this, paramActivity, paramQQGameMsgInfo, paramInt));
      addView(this.fs);
      return;
    }
    catch (Throwable paramQQGameMsgInfo)
    {
      QLog.e("ImgHeaderView", 1, "init imgHeader failed e=" + paramQQGameMsgInfo.toString());
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ImgHeaderView
 * JD-Core Version:    0.7.0.1
 */