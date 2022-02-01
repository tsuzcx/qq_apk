import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct.a;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class xbc
  extends wjd
  implements MessageForDeviceSingleStruct.a
{
  protected final float mDensity;
  View.OnClickListener onClickListener = new xbd(this);
  
  public xbc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    paramQQAppInterface = new Intent();
    paramQQAppInterface.setAction("SmartDevice_clickOnDeviceList");
    BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
  }
  
  private void b(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    int i = ahav.getFileType(ahbj.getExtension(paramMessageForDeviceSingleStruct.strMediaFileName));
    Object localObject2 = ahav.a(paramMessageForDeviceSingleStruct);
    Object localObject1 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject1).setType(10009);
    ((ForwardFileInfo)localObject1).Oj(8);
    ((ForwardFileInfo)localObject1).p(((FileManagerEntity)localObject2).nSessionId);
    ((ForwardFileInfo)localObject1).setFileName(((FileManagerEntity)localObject2).fileName);
    ((ForwardFileInfo)localObject1).jB(((FileManagerEntity)localObject2).uniseq);
    ((ForwardFileInfo)localObject1).setFileSize(((FileManagerEntity)localObject2).fileSize);
    ((ForwardFileInfo)localObject1).aA(((FileManagerEntity)localObject2).strThumbPath);
    ((ForwardFileInfo)localObject1).setLocalPath(((FileManagerEntity)localObject2).getFilePath());
    paramMessageForDeviceSingleStruct = new Intent(this.mContext, FileBrowserActivity.class);
    paramMessageForDeviceSingleStruct.putExtra("fileinfo", (Parcelable)localObject1);
    localObject1 = new ArrayList();
    if (i == 0)
    {
      localObject2 = this.app.b().f(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType);
      if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
        return;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if ((localObject3 instanceof MessageForDeviceSingleStruct))
        {
          localObject3 = (MessageForDeviceSingleStruct)localObject3;
          if (ahav.getFileType(ahbj.getExtension(((MessageForDeviceSingleStruct)localObject3).strMediaFileName)) == 0) {
            ((ArrayList)localObject1).add(String.valueOf(ahav.a((MessageForDeviceSingleStruct)localObject3).nSessionId));
          }
        }
      }
      paramMessageForDeviceSingleStruct.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
    }
    for (;;)
    {
      ((Activity)this.mContext).startActivityForResult(paramMessageForDeviceSingleStruct, 102);
      return;
      if (i == 1)
      {
        ((ArrayList)localObject1).add(String.valueOf(((FileManagerEntity)localObject2).nSessionId));
        paramMessageForDeviceSingleStruct.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
      }
    }
  }
  
  private boolean hL(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("reg");
      if (i == 1) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Exception paramString) {}
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramLinearLayout.setPadding(0, wja.dp2px(11.0F, this.mContext.getResources()), 0, 0);
    paramLinearLayout = (xbc.a)parama;
    parama = paramView;
    if (paramView == null)
    {
      parama = LayoutInflater.from(this.mContext).inflate(2131558901, null);
      paramLinearLayout.IY = ((TextView)parama.findViewById(2131378456));
      paramLinearLayout.IZ = ((TextView)parama.findViewById(2131378455));
      paramLinearLayout.sV = ((ImageView)parama.findViewById(2131378446));
      paramLinearLayout.sW = ((ImageView)parama.findViewById(2131381715));
      paramLinearLayout.Ja = ((TextView)parama.findViewById(2131378441));
      paramLinearLayout.Jb = ((TextView)parama.findViewById(2131378443));
    }
    if ((paramLinearLayout.mMessage instanceof MessageForDeviceSingleStruct)) {}
    for (paramMessageRecord = (MessageForDeviceSingleStruct)paramMessageRecord;; paramMessageRecord = null)
    {
      if (paramMessageRecord == null) {
        return parama;
      }
      long l;
      if ((paramMessageRecord.strTitle != null) && (!TextUtils.isEmpty(paramMessageRecord.strTitle)))
      {
        paramLinearLayout.IY.setText(paramMessageRecord.strTitle);
        paramLinearLayout.IY.setVisibility(0);
        if (paramMessageRecord.nAppearTime == 0L) {
          break label489;
        }
        l = paramMessageRecord.nAppearTime;
        label212:
        if (l == 0L) {
          break label498;
        }
        paramLinearLayout.IZ.setText(aqmu.b(this.mContext, l * 1000L));
        paramLinearLayout.IZ.setVisibility(0);
        label249:
        if ((paramMessageRecord.strDigest == null) || (TextUtils.isEmpty(paramMessageRecord.strDigest))) {
          break label511;
        }
        paramLinearLayout.Ja.setText(paramMessageRecord.strDigest);
        paramLinearLayout.Ja.setVisibility(0);
        label287:
        if ((paramMessageRecord.strGuideWords == null) || (TextUtils.isEmpty(paramMessageRecord.strGuideWords))) {
          break label524;
        }
        paramLinearLayout.Jb.setText(paramMessageRecord.strGuideWords);
        paramLinearLayout.Jb.setVisibility(0);
        label325:
        if (paramMessageRecord.nDataType != 2) {
          break label537;
        }
        paramLinearLayout.sW.setVisibility(0);
        label342:
        a(paramMessageRecord, paramLinearLayout);
        if (aqhq.fileExistsAndNotEmpty(paramMessageRecord.strCoverPath)) {
          break label550;
        }
        ((szy)this.app.getBusinessHandler(49)).a().a(paramMessageRecord, parama, this);
      }
      for (;;)
      {
        if ((!aqhq.fileExistsAndNotEmpty(paramMessageRecord.strMediaPath)) && (aqiw.isWifiConnected(aroi.a().getContext())))
        {
          paramView = (szy)this.app.getBusinessHandler(49);
          ((syw)this.app.getBusinessHandler(51)).a(Long.parseLong(paramMessageRecord.senderuin));
          paramView.a().a(paramMessageRecord);
        }
        parama.setTag(paramLinearLayout);
        parama.setOnClickListener(this.onClickListener);
        parama.setOnTouchListener(paramwlz);
        parama.setOnLongClickListener(paramwlz);
        return parama;
        paramLinearLayout.IY.setVisibility(8);
        break;
        label489:
        l = paramMessageRecord.time;
        break label212;
        label498:
        paramLinearLayout.IZ.setVisibility(8);
        break label249;
        label511:
        paramLinearLayout.Ja.setVisibility(8);
        break label287;
        label524:
        paramLinearLayout.Jb.setVisibility(8);
        break label325;
        label537:
        paramLinearLayout.sW.setVisibility(8);
        break label342;
        label550:
        if ((!TextUtils.isEmpty(paramMessageRecord.faceRect)) && (!aqhq.fileExistsAndNotEmpty(paramMessageRecord.strMediaPath)))
        {
          paramView = (szy)this.app.getBusinessHandler(49);
          if (((syw)this.app.getBusinessHandler(51)).a(Long.parseLong(paramMessageRecord.senderuin)).isAdmin == 1) {
            paramView.a().a(paramMessageRecord);
          }
        }
      }
    }
  }
  
  protected wjd.a a()
  {
    return new xbc.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
      paramContext = ((FragmentActivity)this.mContext).getChatFragment().a();
      paramContext.c(paramChatMessage);
      paramContext.wc(true);
    } while (paramChatMessage == null);
    if (paramChatMessage.istroop == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + paramInt, "", "", "");
      return;
      if (paramChatMessage.istroop == 3000) {
        paramInt = 2;
      } else if (paramChatMessage.istroop == 1) {
        paramInt = 3;
      } else {
        paramInt = 4;
      }
    }
  }
  
  public void a(View paramView, MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    xbc.a locala = (xbc.a)wja.a(paramView);
    if (locala == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceSingleStructBuilder", 2, "error get holder in updateview");
      }
    }
    do
    {
      do
      {
        return;
        paramView = null;
        if ((locala.mMessage instanceof MessageForDeviceSingleStruct)) {
          paramView = (MessageForDeviceSingleStruct)locala.mMessage;
        }
      } while (paramView == null);
      if ((paramView.uniseq == paramMessageForDeviceSingleStruct.uniseq) && (paramView.nCoverSessionID == paramMessageForDeviceSingleStruct.nCoverSessionID))
      {
        paramView.strCoverPath = paramMessageForDeviceSingleStruct.strCoverPath;
        a(paramView, locala);
      }
    } while ((paramView.uniseq != paramMessageForDeviceSingleStruct.uniseq) || (paramView.nMediaSessionID != paramMessageForDeviceSingleStruct.nMediaSessionID));
    paramView.strMediaPath = paramMessageForDeviceSingleStruct.strMediaPath;
  }
  
  protected void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, xbc.a parama)
  {
    if ((paramMessageForDeviceSingleStruct.nDataType == 1) && (aqhq.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strMediaPath))) {}
    for (;;)
    {
      int k;
      int j;
      int i;
      try
      {
        k = ((WindowManager)aroi.a().getContext().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
        j = (int)(this.mDensity * 150.0F);
        i = k;
        if (k <= 0) {
          i = j;
        }
        paramMessageForDeviceSingleStruct = aoki.a(paramMessageForDeviceSingleStruct.strMediaPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
        if (paramMessageForDeviceSingleStruct != null)
        {
          paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
          parama.sV.setImageDrawable(paramMessageForDeviceSingleStruct);
        }
        return;
      }
      catch (Exception paramMessageForDeviceSingleStruct)
      {
        parama.sV.setImageResource(2130838155);
        return;
      }
      if (aqhq.fileExistsAndNotEmpty(paramMessageForDeviceSingleStruct.strCoverPath)) {
        try
        {
          k = ((WindowManager)aroi.a().getContext().getSystemService("window")).getDefaultDisplay().getWidth() - 156;
          j = (int)(this.mDensity * 150.0F);
          i = k;
          if (k <= 0) {
            i = j;
          }
          paramMessageForDeviceSingleStruct = aoki.a(paramMessageForDeviceSingleStruct.strCoverPath, i, j, paramMessageForDeviceSingleStruct.strCoverMD5);
          if (paramMessageForDeviceSingleStruct != null)
          {
            paramMessageForDeviceSingleStruct = URLDrawable.getDrawable(paramMessageForDeviceSingleStruct);
            parama.sV.setImageDrawable(paramMessageForDeviceSingleStruct);
            return;
          }
        }
        catch (Exception paramMessageForDeviceSingleStruct)
        {
          parama.sV.setImageResource(2130838155);
          return;
        }
      }
    }
    parama.sV.setImageResource(2130838155);
  }
  
  public aqob[] a(View paramView)
  {
    paramView = new aqoa();
    paramView.Z(2131365686, this.mContext.getString(2131691404), 2130839081);
    int i = 0;
    if ((this.sessionInfo.cZ == 0) || (this.sessionInfo.cZ == 1) || (this.sessionInfo.cZ == 3000))
    {
      if (this.sessionInfo.cZ == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(60);
        if ((localHotChatManager == null) || (!localHotChatManager.kj(this.sessionInfo.aTl))) {}
      }
      i = 1;
    }
    if ((i != 0) && (ajlc.a().aqX())) {
      paramView.Z(2131372073, this.mContext.getString(2131696127), 2130839094);
    }
    return paramView.a();
  }
  
  class a
    extends wjd.a
  {
    TextView IY;
    TextView IZ;
    TextView Ja;
    TextView Jb;
    ImageView sV;
    ImageView sW;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbc
 * JD-Core Version:    0.7.0.1
 */