import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.dataline.activities.LiteMutiPicViewerActivity.ItemHolder;
import com.dataline.util.widget.AsyncImageView;
import com.dataline.util.widget.WaitTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class bn
  extends BaseAdapter
  implements View.OnClickListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  private bn(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramLiteMutiPicViewerActivity);
  }
  
  public int getCount()
  {
    int j = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount();
    int k = j % 3;
    int i = j;
    if (k != 0) {
      i = j + (3 - k);
    }
    return i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount() - 1) {
      return null;
    }
    return LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getAt(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getCount() - 1) {
      return 0;
    }
    if (paramInt > LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount() - 1) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt == getCount() - 1) {
      if ((LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getComeCount() == LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount()) || (LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).isSendFromLocal()) || (LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).hasSendingOrRecving()))
      {
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setWaitText(String.format(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.getString(2131361898), new Object[] { Integer.valueOf(LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount()) }));
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).b();
        paramViewGroup = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity);
      }
    }
    do
    {
      return paramViewGroup;
      if (!LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).isTimeOut())
      {
        paramInt = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getComeCount();
        i = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount();
        paramView = String.format(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app.a().getString(2131361899), new Object[] { Integer.valueOf(i), Integer.valueOf(i - paramInt) });
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setWaitText(paramView);
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).a();
        break;
      }
      LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).b();
      paramInt = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getComeCount();
      int i = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount();
      paramView = String.format(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app.a().getString(2131361900), new Object[] { Integer.valueOf(i), Integer.valueOf(i - paramInt) });
      LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setWaitText(paramView);
      break;
      if (paramInt <= LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount() - 1) {
        break label403;
      }
      paramViewGroup = paramView;
    } while (paramView != null);
    paramView = new View(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity);
    paramView.setLayoutParams(new AbsListView.LayoutParams(LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.b(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity)));
    paramView.setPadding(LiteMutiPicViewerActivity.c(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.c(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.c(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.c(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity));
    return paramView;
    label403:
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new LiteMutiPicViewerActivity.ItemHolder(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903412, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297996));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131296971);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297997));
      paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296283));
      paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setLayoutParams(new RelativeLayout.LayoutParams(LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.b(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity)));
      paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAdjustViewBounds(false);
      paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(Color.parseColor("#C8C8C8"));
      paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
      paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity), LiteMutiPicViewerActivity.b(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
      paramView.setTag(paramViewGroup);
      localObject = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getAt(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord = ((DataLineMsgRecord)localObject);
      if (localObject != null) {
        break label665;
      }
    }
    label665:
    while (((DataLineMsgRecord)localObject).fileMsgStatus == 1L)
    {
      localObject = new ColorDrawable(Color.parseColor("#C8C8C8"));
      paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawable((Drawable)localObject);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return paramView;
      paramViewGroup = (LiteMutiPicViewerActivity.ItemHolder)paramView.getTag();
      break;
    }
    if ((((DataLineMsgRecord)localObject).path != null) && (new File(((DataLineMsgRecord)localObject).path).exists())) {
      paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(((DataLineMsgRecord)localObject).path);
    }
    while ((!LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).hasSendingOrRecving()) && ((!((DataLineMsgRecord)localObject).issuc) || (((DataLineMsgRecord)localObject).fileMsgStatus != 0L)))
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return paramView;
      if (((DataLineMsgRecord)localObject).thumbPath != null) {
        paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(((DataLineMsgRecord)localObject).thumbPath);
      }
    }
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onClick(View paramView)
  {
    paramView = ((LiteMutiPicViewerActivity.ItemHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
    if (paramView == null) {}
    FileManagerEntity localFileManagerEntity;
    ForwardFileInfo localForwardFileInfo;
    Intent localIntent;
    do
    {
      return;
      localFileManagerEntity = FileManagerUtil.a(paramView);
      localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.a(10009);
      localForwardFileInfo.c(6);
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.d(paramView.filename);
      localForwardFileInfo.c(paramView.sessionid);
      localForwardFileInfo.d(paramView.filesize);
      localForwardFileInfo.a(paramView.path);
      localIntent = new Intent(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity, FileBrowserActivity.class);
      if (localFileManagerEntity.nFileType != 0) {
        break;
      }
      localObject = this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app.a().a(paramView.sessionid);
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((DataLineMsgSet)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
      if ((localDataLineMsgRecord.msgtype == -2000) || ((localDataLineMsgRecord.msgtype == -2005) && (FileManagerUtil.a(localDataLineMsgRecord.filename) == 0)) || ((localDataLineMsgRecord.msgtype == -2335) && (localDataLineMsgRecord.bIsMoloImage))) {
        if (localDataLineMsgRecord == paramView) {
          localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
        } else {
          localArrayList.add(String.valueOf(FileManagerUtil.a(localDataLineMsgRecord).nSessionId));
        }
      }
    }
    localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bn
 * JD-Core Version:    0.7.0.1
 */