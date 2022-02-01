import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ajxw
  extends BaseAdapter
{
  private final String TAG = "CommentsAdapter";
  private boolean Yp;
  private ajzq jdField_a_of_type_Ajzq;
  private Comments jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
  private int ayj;
  private VideoData b;
  public boolean cqI;
  private int dlF = 1;
  private int dlG = 2;
  private Context mContext;
  private LayoutInflater mInflater;
  private Paint mTextPaint;
  
  public ajxw(Context paramContext, Comments paramComments, VideoData paramVideoData, ajzq paramajzq, Paint paramPaint, int paramInt)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments = paramComments;
    this.b = paramVideoData;
    this.jdField_a_of_type_Ajzq = paramajzq;
    this.mTextPaint = paramPaint;
    this.ayj = paramInt;
  }
  
  public void Mt(boolean paramBoolean)
  {
    this.Yp = paramBoolean;
  }
  
  public Comments.Comment a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.size())) {
      return (Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.size() > 0)) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.size();
    }
    return 1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentsAdapter", 2, "getview position is: " + paramInt);
    }
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.size() > 0)) {
      if ((paramView == null) || (!(paramView.getTag() instanceof ajya)))
      {
        localObject1 = new ajya();
        paramView = this.mInflater.inflate(2131561467, paramViewGroup, false);
        ((ajya)localObject1).Bp = ((ImageView)paramView.findViewById(2131369715));
        ((ajya)localObject1).fe = ((TextView)paramView.findViewById(2131380814));
        ((ajya)localObject1).Vg = ((TextView)paramView.findViewById(2131380630));
        ((ajya)localObject1).EK = ((TextView)paramView.findViewById(2131380857));
        ((ajya)localObject1).Bq = ((ImageView)paramView.findViewById(2131368609));
        ((ajya)localObject1).Br = ((ImageView)paramView.findViewById(2131366713));
        ((ajya)localObject1).ho = ((ImageView)paramView.findViewById(2131380015));
        paramView.setTag(2131365013, localObject1);
        ((ajya)localObject1).fe.setText(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).name);
        if ((((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).ado <= 0L) && (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).adp <= 0L)) {
          break label687;
        }
        ((ajya)localObject1).gM(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).bSx, ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).content);
        label315:
        ((ajya)localObject1).setTime(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).timestamp);
        Object localObject2 = ((BaseActivity)this.mContext).app;
        String str1 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).headUrl;
        String str2 = String.valueOf(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).uid);
        if (((str1 != null) && (!str1.isEmpty())) || (!str2.equals(((QQAppInterface)localObject2).getCurrentAccountUin()))) {
          break label714;
        }
        localObject2 = aqdj.a((AppInterface)localObject2, 32, str2, 3, ((ajya)localObject1).Bp.getResources().getDrawable(2130846334), ((ajya)localObject1).Bp.getResources().getDrawable(2130846334));
        ((ajya)localObject1).Bp.setImageDrawable((Drawable)localObject2);
        label470:
        ((ajya)localObject1).a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).a, this.ayj, this.mTextPaint, this.Yp);
        long l1 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).uid;
        long l2 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).nowId;
        long l3 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).nowUserType;
        ((ajya)localObject1).Bp.setOnClickListener(new ajxx(this, l1, l2, l3));
        if (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).type == 2) {
          ((ajya)localObject1).ho.setVisibility(0);
        }
        paramView.setTag(2131365004, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt));
        paramView.setTag(2131365056, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments);
      }
    }
    for (;;)
    {
      label655:
      for (localObject1 = paramView;; localObject1 = paramView)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (ajya)paramView.getTag();
        break;
        label687:
        ((ajya)localObject1).setContent(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).content);
        break label315;
        label714:
        ajxr.a().a(((ajya)localObject1).Bp, ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(paramInt)).headUrl, ((ajya)localObject1).Bp.getResources().getDrawable(2130846334), ((ajya)localObject1).Bp.getResources().getDrawable(2130846334), null, true);
        break label470;
        if (this.b.isInvalid())
        {
          paramView = new View(this.mContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
          break label655;
        }
        if (this.cqI)
        {
          if ((paramView != null) && ((paramView.getTag() instanceof String)) && ("badnet".equals((String)paramView.getTag()))) {}
          for (;;)
          {
            paramView.setBackgroundColor(Color.parseColor("#ffffff"));
            paramView.findViewById(2131370723).setOnClickListener(new ajxy(this));
            paramView.setTag("badnet");
            break;
            paramView = this.mInflater.inflate(2131561457, paramViewGroup, false);
          }
        }
        if ((paramView == null) || (!(paramView.getTag() instanceof String)) || (!"empty".equals((String)paramView.getTag()))) {
          break label940;
        }
      }
      label940:
      paramView = this.mInflater.inflate(2131561458, paramViewGroup, false);
      paramView.setTag("empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxw
 * JD-Core Version:    0.7.0.1
 */