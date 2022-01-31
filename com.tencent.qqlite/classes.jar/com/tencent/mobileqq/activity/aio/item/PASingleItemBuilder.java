package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bxd;
import bxe;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.open.business.base.AppUtil;
import java.util.ArrayList;
import java.util.List;

public class PASingleItemBuilder
  extends AbstractChatItemBuilder
{
  View.OnClickListener a;
  
  public PASingleItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bxd(this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (PAMessageUtil.a(paramString1, paramContext)) {}
    while ((paramString2 != null) && (paramString2.equals("open_local"))) {
      return;
    }
    paramString1 = new Intent(paramContext, PublicAccountBrowser.class);
    paramString1.putExtra("uin", paramQQAppInterface.a());
    paramString1.putExtra("url", paramString3);
    paramString1.putExtra("assignBackText", paramContext.getResources().getString(2131363123));
    paramString1.putExtra("puin", paramString4);
    paramString1.putExtra("source_name", paramString5);
    paramString1.putExtra("fromAio", true);
    PublicAccountUtil.a(paramString1, paramString3);
    paramContext.startActivity(paramString1);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", paramString4, "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString3, "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    int i = 0;
    paramString2 = Uri.parse(paramString2);
    paramString1 = paramString2.getScheme();
    paramString2 = paramString2.getHost();
    if ((!TextUtils.isEmpty(paramString1)) && (AppUtil.a(paramString1)))
    {
      AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
      if (AppLaucherHelper.a(paramString2) == 0) {}
      Bundle localBundle;
      int j;
      for (;;)
      {
        localBundle = AppLaucherHelper.a(paramString2);
        j = localBundle.getInt("a_launch_mode", 268435456);
        if (i == 0) {
          break;
        }
        localAppLaucherHelper.a(paramQQAppInterface, paramContext, String.valueOf(paramLong), paramString2, paramString1, j);
        return true;
        i = 1;
      }
      return AppUtil.a(paramContext, paramString1, localBundle, j);
    }
    return false;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout.setPadding(0, AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = paramView;
    if (paramView == null) {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903091, null);
    }
    Object localObject3 = (MessageForPubAccount)paramMessageRecord;
    paramMessageRecord = (bxe)paramViewHolder;
    paramViewHolder = paramLinearLayout.findViewById(2131296713);
    Object localObject2 = (TextView)paramLinearLayout.findViewById(2131296715);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(2131296716);
    Object localObject1 = (ImageView)paramLinearLayout.findViewById(2131296717);
    Object localObject5 = (TextView)paramLinearLayout.findViewById(2131296718);
    Object localObject6 = (TextView)paramLinearLayout.findViewById(2131296719);
    Object localObject7 = (TextView)paramLinearLayout.findViewById(2131296720);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(2131296721);
    TextView localTextView3 = (TextView)paramLinearLayout.findViewById(2131296722);
    Object localObject4 = (TextView)paramLinearLayout.findViewById(2131296724);
    paramView = new ArrayList();
    paramView.add(localObject5);
    paramView.add(localObject6);
    paramView.add(localObject7);
    paramView.add(localTextView2);
    paramView.add(localTextView3);
    localObject6 = ((MessageForPubAccount)localObject3).mPAMessage;
    localObject5 = (PAMessage.Item)((PAMessage)localObject6).items.get(0);
    paramMessageRecord.c = ((PAMessage.Item)localObject5).url;
    paramMessageRecord.jdField_b_of_type_JavaLangString = ((PAMessage.Item)localObject5).actionUrl;
    paramMessageRecord.jdField_a_of_type_JavaLangString = ((PAMessage.Item)localObject5).nativeJumpString;
    paramMessageRecord.jdField_b_of_type_Int = ((PAMessage)localObject6).type;
    paramMessageRecord.jdField_a_of_type_Int = 5;
    paramMessageRecord.jdField_a_of_type_JavaLangObject = Long.valueOf(((MessageForPubAccount)localObject3).uniseq);
    paramMessageRecord.d = ((PAMessage)localObject6).moreText;
    paramMessageRecord.jdField_a_of_type_Long = ((PAMessage.Item)localObject5).appId;
    paramMessageRecord.e = ((PAMessage.Item)localObject5).actionData;
    paramMessageRecord.f = ((PAMessage.Item)localObject5).a_actionData;
    paramMessageRecord.g = ((PAMessage.Item)localObject5).i_actionData;
    int i;
    long l;
    if (!TextUtils.isEmpty(((PAMessage)localObject6).moreText))
    {
      ((TextView)localObject4).setText(((PAMessage)localObject6).moreText);
      localObject3 = Util.e(((PAMessage.Item)localObject5).title);
      ((TextView)localObject2).setText((CharSequence)localObject3);
      if (((PAMessage.Item)localObject5).mVideoFlag == 1)
      {
        localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838364);
        i = Util.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        ((Drawable)localObject4).setBounds(i, 0, Util.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + i, Util.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
        localObject7 = new SpannableString((String)localObject3 + "1");
        ((SpannableString)localObject7).setSpan(new ImageSpan((Drawable)localObject4, 0), ((String)localObject3).length(), ((String)localObject3).length() + 1, 17);
        ((TextView)localObject2).setText((CharSequence)localObject7);
      }
      if (((PAMessage.Item)localObject5).time == 0L) {
        break label679;
      }
      l = ((PAMessage.Item)localObject5).time;
      label519:
      if (l == 0L) {
        break label689;
      }
      localTextView1.setText(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, l * 1000L));
      localTextView1.setVisibility(0);
    }
    for (;;)
    {
      try
      {
        localObject2 = URLDrawable.getDrawable(PubAccountHttpDownloader.a(((PAMessage.Item)localObject5).cover));
        ((URLDrawable)localObject2).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        localObject1 = ((PAMessage.Item)localObject5).digestList;
        if (localObject1 != null)
        {
          i = ((List)localObject1).size();
          int j = 0;
          if (j < paramView.size())
          {
            localObject2 = (TextView)paramView.get(j);
            if (i > j)
            {
              ((TextView)localObject2).setText((CharSequence)((List)localObject1).get(j));
              ((TextView)localObject2).setVisibility(0);
              j += 1;
              continue;
              ((TextView)localObject4).setText(2131364062);
              break;
              label679:
              l = ((PAMessage)localObject6).sendTime;
              break label519;
              label689:
              localTextView1.setVisibility(8);
              continue;
            }
          }
        }
      }
      catch (Exception localException)
      {
        ((ImageView)localObject1).setImageResource(2130837552);
        continue;
        localException.setVisibility(8);
        continue;
        paramViewHolder.setTag(paramMessageRecord);
        paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return paramLinearLayout;
      }
      i = 0;
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new bxe(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramContext = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      PublicAccountUtil.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131298958, this.jdField_a_of_type_AndroidContentContext.getString(2131363086));
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder
 * JD-Core Version:    0.7.0.1
 */