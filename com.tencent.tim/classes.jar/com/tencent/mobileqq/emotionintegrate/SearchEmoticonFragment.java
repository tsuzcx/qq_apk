package com.tencent.mobileqq.emotionintegrate;

import acfp;
import afnu;
import ahgq;
import anbi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aoiz;
import aoop;
import aqfw;
import aqhq;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;
import mqq.os.MqqHandler;
import syd;
import xtm;

public class SearchEmoticonFragment
  extends AIOEmotionBaseFragment
  implements View.OnClickListener
{
  public static String bEM = "forward_search_emoticon";
  View BZ;
  TextView RC;
  TextView RD;
  private SearchEmoticonWebBean a;
  private int bYV;
  syd c;
  private Drawable dZ;
  private float density;
  Button ge;
  Button gf;
  private Activity mActivity;
  ImageView yX;
  ImageView za;
  
  public static Intent a(MessageForPic paramMessageForPic, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("forward_type", 1);
    paramQQAppInterface.putInt("forward_source_uin_type", paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_filepath", paramMessageForPic.path);
    localIntent.putExtra(bEM, true);
    localIntent.putExtra("forward_download_image_task_key", paramMessageForPic.frienduin + paramMessageForPic.uniseq + paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_org_uin", paramMessageForPic.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_server_path", paramMessageForPic.uuid);
    localIntent.putExtra("forward_download_image_item_id", paramMessageForPic.uniseq);
    localIntent.putExtra("forward_photo_isSend", paramMessageForPic.issend);
    localIntent.putExtra("forward_photo_md5", paramMessageForPic.md5);
    localIntent.putExtra("forward_photo_group_fileid", paramMessageForPic.groupFileID);
    localIntent.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", paramMessageForPic.fileSizeFlag);
    localIntent.putExtras(paramQQAppInterface);
    if ((aqfw.mn(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003))
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label352;
      }
    }
    label352:
    for (paramInt = 65537;; paramInt = 1)
    {
      paramQQAppInterface = aoop.a(paramMessageForPic, paramInt);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_thumb_url", paramQQAppInterface.toString());
      localIntent.putExtra("FORWARD_URL_KEY", paramMessageForPic.localUUID);
      paramContext = ForwardUtils.a(paramContext, paramMessageForPic);
      localIntent.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      if (!new File(paramMessageForPic.path).exists()) {
        break label357;
      }
      localIntent.putExtra("forward_extra", paramMessageForPic.path);
      localIntent.putExtra("BUSI_TYPE", 1009);
      return localIntent;
      paramInt = 0;
      break;
    }
    label357:
    paramQQAppInterface = null;
    paramContext = paramContext.getURL().toString();
    if (aoiz.hasFile(paramContext))
    {
      paramContext = aoiz.getFile(paramContext);
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null) {
        paramMessageForPic = paramContext.getAbsolutePath();
      }
    }
    for (;;)
    {
      localIntent.putExtra("forward_extra", paramMessageForPic);
      break;
      paramContext = aoiz.getFile(aoop.a(paramMessageForPic, 65537).toString());
      paramMessageForPic = paramQQAppInterface;
      if (paramContext != null)
      {
        paramMessageForPic = paramQQAppInterface;
        if (paramContext.exists()) {
          paramMessageForPic = paramContext.getAbsolutePath();
        }
      }
    }
  }
  
  public static void a(Context paramContext, SearchEmoticonWebBean paramSearchEmoticonWebBean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("SearchEmoticonWebBean", paramSearchEmoticonWebBean);
    PublicFragmentActivity.start(paramContext, localIntent, SearchEmoticonFragment.class);
  }
  
  private void m(MessageForPic paramMessageForPic)
  {
    ThreadManager.getFileThreadHandler().post(new SearchEmoticonFragment.2(this, paramMessageForPic));
  }
  
  public boolean ajM()
  {
    return false;
  }
  
  protected void c(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem) {}
  
  protected void dbC() {}
  
  public View f(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131563334, paramViewGroup, false);
  }
  
  protected void gw(View paramView)
  {
    this.RC = ((TextView)paramView.findViewById(2131362398));
    this.RD = ((TextView)paramView.findViewById(2131365766));
    this.BZ = paramView.findViewById(2131366376);
    this.yX = ((ImageView)paramView.findViewById(2131365765));
    this.za = ((ImageView)paramView.findViewById(2131362396));
    ImageView localImageView = (ImageView)paramView.findViewById(2131362394);
    this.c = new syd();
    this.c.init(super.getActivity(), localImageView);
    this.dZ = getResources().getDrawable(2130838388);
    this.density = getResources().getDisplayMetrics().density;
    this.bYV = ((int)(this.density * 6.0F));
    this.ge = ((Button)paramView.findViewById(2131378012));
    this.gf = ((Button)paramView.findViewById(2131362241));
    this.ge.setOnClickListener(this);
    this.gf.setOnClickListener(this);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.a = ((SearchEmoticonWebBean)this.mActivity.getIntent().getParcelableExtra("SearchEmoticonWebBean"));
    if (this.a == null)
    {
      this.a = new SearchEmoticonWebBean();
      this.a.cTB = 0;
    }
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    paramBundle.mLoadingDrawable = this.dZ;
    paramBundle.mFailedDrawable = this.dZ;
    paramBundle.mGifRoundCorner = this.bYV;
    paramBundle.mPlayGifImage = true;
    paramBundle = URLDrawable.getDrawable(this.a.bEO, paramBundle);
    this.za.setImageDrawable(paramBundle);
    this.a.bEV = aoiz.getFilePath(this.a.bEO);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.mContext.getString(2131720735));
      paramIntent = new Bundle(paramIntent.getExtras());
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      if (super.getApp() != null) {
        ForwardUtils.a(super.getApp(), super.getActivity(), this.mContext, localIntent, ThreadManager.getUIHandler());
      }
      anot.a(null, "dc00898", "", "", "0X8009EAC", "0X8009EAC", 0, 0, "", "", "", "");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = getApp();
    if (localObject == null) {
      QLog.d("SearchEmoticonFragment", 1, "error runtime");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!aqhq.fileExists(this.a.bEV))
      {
        QQToast.a(this.mActivity, 1, acfp.m(2131714107), 0).show();
      }
      else
      {
        MessageForPic localMessageForPic = (MessageForPic)anbi.d(-2000);
        localMessageForPic.path = this.a.bEV;
        localMessageForPic.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(this.a.bEV));
        localMessageForPic.thumbMsgUrl = this.a.bEO;
        localMessageForPic.bigMsgUrl = this.a.bEO;
        localMessageForPic.imageType = 2000;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131362241: 
          URLDrawable localURLDrawable = (URLDrawable)this.za.getDrawable();
          localURLDrawable.setTag(localMessageForPic);
          xtm.a(this.mContext, (QQAppInterface)localObject, localURLDrawable, localMessageForPic.frienduin, getActivity().getResources().getDimensionPixelSize(2131299627), null, localMessageForPic.picExtraData);
          anot.a(null, "dc00898", "", "", "0X8009EAD", "0X8009EAD", 0, 0, "", "", "", "");
          afnu.c((QQAppInterface)localObject, 5, localMessageForPic.md5, null);
          break;
        case 2131378012: 
          if (QLog.isColorLevel()) {
            QLog.d("SearchEmoticonFragment", 2, "发送给好友");
          }
          localObject = a(localMessageForPic, 0, (QQAppInterface)localObject, this.mContext);
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
          ahgq.f(super.getActivity(), (Intent)localObject, 1);
          m(localMessageForPic);
          anot.a(null, "dc00898", "", "", "0X8009EAA", "0X8009EAA", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    anot.a(null, "dc00898", "", "", "0X8009EA9", "0X8009EA9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment
 * JD-Core Version:    0.7.0.1
 */