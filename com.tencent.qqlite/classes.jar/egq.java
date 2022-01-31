import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class egq
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    localObject1 = paramView.findViewById(2131296292);
    if (localObject1 == null) {}
    Object localObject2;
    Context localContext;
    Object localObject3;
    Intent localIntent;
    for (;;)
    {
      return;
      paramView = ((View)localObject1).getTag(2131296292);
      if ((paramView instanceof StructMsgForImageShare))
      {
        localObject2 = (StructMsgForImageShare)paramView;
        localContext = ((View)localObject1).getContext();
        try
        {
          paramView = (QQAppInterface)((BaseApplicationImpl)localContext.getApplicationContext()).getAppRuntime(((StructMsgForImageShare)localObject2).currentAccountUin);
          AbsShareMsg.doReport(paramView, (AbsShareMsg)localObject2);
          localObject3 = ((StructMsgForImageShare)localObject2).getFirstImageElement();
          if (localObject3 != null) {
            if ((!MsgUtils.b(((StructMsgForImageShare)localObject2).mIsSend)) && (((StructMsgItemImage)localObject3).a != null))
            {
              paramView = PicItemBuilder.a(localContext, ((StructMsgItemImage)localObject3).a);
              if (paramView != null) {
                if (paramView.getStatus() == 2)
                {
                  paramView.restartDownload();
                  return;
                }
              }
            }
          }
        }
        catch (AccountNotMatchException paramView)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("StructMsg", 2, paramView.getStackTrace().toString());
            }
            paramView = null;
          }
          if ((paramView.getStatus() == 0) && (!paramView.isDownloadStarted()))
          {
            paramView.startDownload();
            return;
          }
          localIntent = new Intent(localContext, AIOGalleryActivity.class);
          localIntent.putExtra("curType", ((StructMsgForImageShare)localObject2).uinType);
          localIntent.putExtra("_id", ((StructMsgForImageShare)localObject2).uniseq);
          localIntent.putExtra("urlAtServer", ((StructMsgItemImage)localObject3).i);
          localIntent.putExtra("KEY_FILE_ID", ((StructMsgItemImage)localObject3).b);
          localIntent.putExtra("picMD5", ((StructMsgItemImage)localObject3).j);
          localIntent.putExtra("url", ((StructMsgItemImage)localObject3).h);
          localIntent.putExtra("friendUin", ((StructMsgForImageShare)localObject2).uin);
          localIntent.putExtra("KEY_MSG_VERSION_CODE", ((StructMsgForImageShare)localObject2).messageVersion);
          localIntent.putExtra("isSend", ((StructMsgForImageShare)localObject2).mIsSend);
          localIntent.putExtra("KEY_BUSI_TYPE", 1030);
          localIntent.putExtra("IS_FROMOTHER_TERMINAL_KEY", MsgUtils.c(((StructMsgForImageShare)localObject2).mIsSend));
          localIntent.putExtra("uin", ((StructMsgForImageShare)localObject2).uin);
          if (((StructMsgForImageShare)localObject2).mIsSend != 1) {}
        }
      }
    }
    for (paramView = ((StructMsgForImageShare)localObject2).currentAccountUin;; paramView = ((StructMsgForImageShare)localObject2).uin)
    {
      localIntent.putExtra("KEY_TROOP_CODE", paramView);
      localIntent.putExtra("fileSize", ((StructMsgItemImage)localObject3).c);
      localIntent.putExtra("KEY_TIME", ((StructMsgItemImage)localObject3).d);
      localIntent.putExtra("KEY_SUB_VERSION", 5);
      localIntent.putExtra("KEY_FILE_SIZE_FLAG", 0);
      localIntent.putExtra("IS_APP_SHARE_PIC", true);
      localIntent.putExtra("uniSeq", ((StructMsgForImageShare)localObject2).uniseq);
      localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a((View)localObject1));
      localObject2 = ((StructMsgItemImage)localObject3).a;
      if (localObject2 == null) {
        break;
      }
      localIntent.addFlags(603979776);
      localObject1 = ((MessageForPic)localObject2).selfuin;
      paramView = (View)localObject1;
      if (((MessageForPic)localObject2).isMultiMsg) {}
      try
      {
        localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramView = (View)localObject1;
        if ((localObject3 instanceof QQAppInterface)) {
          paramView = ((AppRuntime)localObject3).getAccount();
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView = (View)localObject1;
        }
      }
      paramView = new AIOImageProviderService(paramView, ((MessageForPic)localObject2).frienduin, ((MessageForPic)localObject2).istroop, (MessageForPic)localObject2);
      localObject1 = AIOGalleryUtils.a((MessageForPic)localObject2);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramView.asBinder()));
      ((Bundle)localObject2).putParcelable("extra.EXTRA_CURRENT_IMAGE", (Parcelable)localObject1);
      localIntent.putExtras((Bundle)localObject2);
      localContext.startActivity(localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     egq
 * JD-Core Version:    0.7.0.1
 */