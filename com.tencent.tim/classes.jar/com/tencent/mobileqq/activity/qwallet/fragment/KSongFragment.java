package com.tencent.mobileqq.activity.qwallet.fragment;

import aaay;
import aadk;
import aagd;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import aqmr;
import avor;
import avox;
import avox.a;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class KSongFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private TextView NF;
  private KsongBundleInfo a = new KsongBundleInfo();
  private long mlastInvalidatetime;
  private aadk redManager;
  
  private void ctl()
  {
    try
    {
      if (!aqmr.isEmpty(this.a.biz_params))
      {
        JSONObject localJSONObject = new JSONObject(this.a.biz_params);
        this.a.song_id = localJSONObject.optString("song_id");
        this.a.song_name = localJSONObject.optString("song_name");
        this.a.song_singer = localJSONObject.optString("song_singer");
      }
      if (!TextUtils.isEmpty(this.a.song_id))
      {
        this.NF.setText(String.format("%s %s", new Object[] { this.a.song_name, this.a.song_singer }));
        this.NF.setTextColor(-16777216);
        Wa();
      }
      this.a.biz_params = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("KSongFragment", 2, "setSongInfoOnControl throw an exception: " + localException);
    }
  }
  
  private void onConfirmClick()
  {
    long l = System.currentTimeMillis();
    if (this.mlastInvalidatetime + 1000L > l) {
      return;
    }
    this.mlastInvalidatetime = l;
    String str1 = this.numTxt.getText().toString();
    String str2 = this.aV.getText().toString();
    Map localMap = this.mActivity.Y();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.a.song_name + "-" + this.a.song_singer);
    localMap.put("feedsid", this.a.song_id);
    localMap.put("bus_type", "2");
    localMap.put("total_num", str1);
    localMap.put("total_amount", avor.hX(str2));
    localMap.put("channel", "" + this.channel);
    this.mLogic.Z(localMap);
  }
  
  public boolean Wa()
  {
    if ((super.Wa()) && (this.a.song_id == null)) {
      this.cU.setEnabled(false);
    }
    return this.cU.isEnabled();
  }
  
  public void ao(Bundle paramBundle)
  {
    super.ao(paramBundle);
    avox.a(paramBundle, this.a);
    this.NF = ((TextView)this.view.findViewById(2131364607));
    this.NF.setOnClickListener(this);
    this.cU.setOnClickListener(this);
    aagd.k(this.NF, 0.6F);
    ctl();
    if (QLog.isColorLevel()) {
      QLog.i("KSongFragment", 2, "biz_params: " + this.a.biz_params);
    }
  }
  
  public int getLayout()
  {
    return 2131562122;
  }
  
  public void initData()
  {
    cth();
    this.redManager = ((aadk)this.mQApp.getManager(273));
    this.redManager.Ag("3001");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 16) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("h5arg");
      QLog.i("KSongFragment", 2, "h5call = " + paramIntent);
    }
    try
    {
      paramIntent = new JSONObject(paramIntent);
      this.a.song_id = paramIntent.optString("musicID");
      this.a.song_singer = paramIntent.optString("singer");
      this.a.song_name = paramIntent.optString("musicName");
      ctl();
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    for (;;)
    {
      try
      {
        this.redManager.Af("3001");
        this.mActivity.zY("ksong.wrappacket.choosesong");
        if (TextUtils.isEmpty(this.a.pick_entry))
        {
          QLog.i("KSongFragment", 2, "error, url is null...");
          localObject = getHbPannelConfig(7);
          if (localObject == null) {
            break;
          }
          this.a.pick_entry = ((JSONObject)localObject).optString("pick_entry", "https://h5.qianbao.qq.com/ktvredpacket");
        }
        StringBuilder localStringBuilder = new StringBuilder().append("%s");
        if (!this.a.pick_entry.contains("?")) {
          break label263;
        }
        if (!this.a.pick_entry.endsWith("?")) {
          break label207;
        }
        Object localObject = "";
        localObject = (String)localObject + "musicID=%s";
        if (this.a.song_id != null) {
          break label214;
        }
        localObject = this.a.pick_entry;
        openUrl((String)localObject);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break;
      label207:
      String str = "&";
      continue;
      label214:
      str = String.format(str, new Object[] { this.a.pick_entry, this.a.song_id });
      continue;
      this.mActivity.zY("ksong.wrappacket.wrap");
      onConfirmClick();
      break;
      label263:
      str = "?";
    }
  }
  
  protected String qf()
  {
    return "";
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("KSongFragment", 2, "ksong enter...");
      if (this.mActivity != null) {
        this.mActivity.zY("ksong.wrappacket.show");
      }
    }
  }
  
  public static class KsongBundleInfo
    extends avox.a
  {
    public String song_id;
    public String song_name;
    public String song_singer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.KSongFragment
 * JD-Core Version:    0.7.0.1
 */