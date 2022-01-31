import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.widget.XListView;
import java.util.List;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;

public class dhj
  extends FacePreloadBaseAdapter
{
  public dhj(SearchTroopListActivity paramSearchTroopListActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
  }
  
  private CharSequence a(SearchGroup.GroupInfo paramGroupInfo)
  {
    String str = this.a.getString(2131559115, new Object[] { Integer.valueOf(paramGroupInfo.dwCurMemberNum.get()) });
    if (!paramGroupInfo.bSameCity.get()) {
      return str;
    }
    paramGroupInfo = this.a.getString(2131559116, new Object[] { "[icon]" });
    paramGroupInfo = new SpannableString(str + paramGroupInfo);
    paramGroupInfo.setSpan(new ImageSpan(this.a, 2130840357, 1), str.length(), str.length() + "[icon]".length(), 17);
    return paramGroupInfo;
  }
  
  private void a(SearchGroup.GroupInfo paramGroupInfo, dhl paramdhl)
  {
    paramdhl.jdField_a_of_type_TencentImKqqSearchgroupSearchGroup$GroupInfo = paramGroupInfo;
    paramdhl.jdField_a_of_type_JavaLangString = String.valueOf(paramGroupInfo.dwGroupCode.get());
    Bitmap localBitmap = a(4, String.valueOf(paramGroupInfo.dwGroupCode.get()));
    paramdhl.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    paramdhl.jdField_a_of_type_AndroidWidgetTextView.setText(paramGroupInfo.sGroupName.get());
    if ((paramGroupInfo.dwGroupFlagExt.get() & 0x800) != 0) {
      if (paramGroupInfo.dwAuthGroupType.get() == 2)
      {
        paramdhl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramdhl.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838181);
      }
    }
    for (;;)
    {
      paramdhl.b.setText(a(paramGroupInfo));
      paramdhl.jdField_c_of_type_AndroidWidgetTextView.setText(new QQText(paramGroupInfo.sGroupFingerMem.get(), 3));
      paramdhl.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      return;
      if (paramGroupInfo.dwAuthGroupType.get() == 1)
      {
        paramdhl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramdhl.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838357);
      }
      else
      {
        paramdhl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        paramdhl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  protected Object a(int paramInt)
  {
    SearchGroup.GroupInfo localGroupInfo = a(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_Int = 4;
    localFaceInfo.jdField_a_of_type_JavaLangString = String.valueOf(localGroupInfo.dwGroupCode.get());
    return localFaceInfo;
  }
  
  public SearchGroup.GroupInfo a(int paramInt)
  {
    return (SearchGroup.GroupInfo)this.a.a.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((SearchGroup.GroupInfo)this.a.a.get(paramInt)).dwGroupCode.get();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2130903993, null);
      paramView = new dhl(null);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131232316));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131231399));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131232318));
      paramView.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      paramView.b = ((TextView)localView.findViewById(2131232320));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131232321));
      paramView.jdField_c_of_type_AndroidWidgetTextView.setEditableFactory(QQTextBuilder.a);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(a(paramInt), paramViewGroup);
      return localView;
      paramViewGroup = (dhl)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhj
 * JD-Core Version:    0.7.0.1
 */