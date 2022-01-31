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
import com.dataline.activities.DLFileViewerActivity;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.dataline.activities.LiteMutiPicViewerActivity.ItemHolder;
import com.dataline.util.widget.AsyncImageView;
import com.dataline.util.widget.WaitTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class cm
  extends BaseAdapter
  implements View.OnClickListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  private cm(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity)
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
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setWaitText(String.format(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.getString(2131558571), new Object[] { Integer.valueOf(LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount()) }));
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
        paramView = String.format(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.b.a().getString(2131558572), new Object[] { Integer.valueOf(i), Integer.valueOf(i - paramInt) });
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setWaitText(paramView);
        LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).a();
        break;
      }
      LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).b();
      paramInt = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getComeCount();
      int i = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getTotalCount();
      paramView = String.format(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.b.a().getString(2131558573), new Object[] { Integer.valueOf(i), Integer.valueOf(i - paramInt) });
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903484, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232708));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131231520);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232709));
      paramViewGroup.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131230758));
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
    if (new File(((DataLineMsgRecord)localObject).path).exists()) {
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
    if (paramView == null) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity, DLFileViewerActivity.class);
    localIntent.putExtra("dl_file_info_session_id", paramView.sessionid);
    localIntent.putExtra("dl_file_use_set", true);
    if (-2000 == paramView.msgtype) {
      localIntent.putExtra("dl_file_type", 0);
    }
    this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     cm
 * JD-Core Version:    0.7.0.1
 */