import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SpaceGateActivity;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.widget.XCursorAdapter;
import java.util.Map;

public class djk
  extends XCursorAdapter
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  private String jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_b_of_type_JavaLangString = "";
  private Drawable c;
  
  public djk(SpaceGateActivity paramSpaceGateActivity, Cursor paramCursor)
  {
    super(paramSpaceGateActivity, paramCursor);
    b();
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramSpaceGateActivity.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839636);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839634);
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839638);
  }
  
  private String a(String paramString, long paramLong)
  {
    return TimeFormatterUtils.a(1000L * paramLong, true, this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setBackgroundResource(2130840213);
    if (paramInt > 99)
    {
      paramTextView.setText("99+");
      paramTextView.setVisibility(0);
      return;
    }
    if (paramInt > 0)
    {
      paramTextView.setText(String.valueOf(paramInt));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(4);
  }
  
  private void a(TextView paramTextView, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    paramTextView.setText(paramMessage.msg);
    MsgUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity.b, paramMessage, paramTextView, 1009, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.c, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  private void b()
  {
    String str = Settings.System.getString(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), "date_format");
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_JavaLangString = str;
      return;
    }
    this.jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
  }
  
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903928, paramViewGroup, false);
  }
  
  public void a(Cursor paramCursor)
  {
    if (SpaceGateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity).a() == -1)
    {
      super.a(paramCursor);
      notifyDataSetChanged();
    }
  }
  
  public void a(View paramView, Context paramContext, Cursor paramCursor)
  {
    String str = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
    Object localObject2 = (djm)paramView.getTag();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new djm(null);
      ((djm)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131231416));
      ((djm)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131230940));
      ((djm)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      ((djm)localObject1).b = ((TextView)paramView.findViewById(16908309));
      ((djm)localObject1).c = ((TextView)paramView.findViewById(2131231883));
      ((djm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131234180));
      ((djm)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131230987));
      ((djm)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131231701));
      paramView.setTag(localObject1);
      ((djm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(SpaceGateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity));
      ((djm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
    }
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity.b.a().a(str, 1009);
    long l = paramCursor.getLong(paramCursor.getColumnIndex("time"));
    ((djm)localObject1).c.setText(a(str, l));
    localObject2 = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
    if ((localObject2 != null) && (!((String)localObject2).equals("")))
    {
      paramView = (View)localObject2;
      if (!str.equals(localObject2)) {}
    }
    else
    {
      if (!SpaceGateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity).containsKey(str)) {
        SpaceGateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity).a(str);
      }
      paramView = str;
    }
    paramCursor = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
    SpaceGateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity).put(str, paramCursor);
    ((djm)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    a(((djm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity.b.a().a(localMessage.frienduin, localMessage.istroop));
    a(((djm)localObject1).b, paramContext, localMessage);
    paramContext = str + "_" + 1009;
    if (((djm)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout != null)
    {
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(paramContext))) {
        ((djm)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.b();
      }
    }
    else
    {
      new djl(this, str);
      paramContext = this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity.b.b(str);
      if (paramContext == null) {
        break label559;
      }
      ((djm)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
    }
    for (;;)
    {
      paramContext = new ProfileActivity.AllInOne(str, -1);
      paramContext.g = paramView;
      ((djm)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2130838010, paramContext);
      ((djm)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(paramContext);
      ((djm)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity);
      return;
      ((djm)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.c();
      break;
      label559:
      ((djm)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity.getResources().getDrawable(2130838010));
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public long getItemId(int paramInt)
  {
    a().moveToPosition(paramInt);
    return Long.valueOf(a().getString(a().getColumnIndex("senderuin"))).longValue();
  }
  
  public void notifyDataSetChanged()
  {
    if (SpaceGateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity).a() == -1) {
      super.notifyDataSetChanged();
    }
  }
  
  public void notifyDataSetInvalidated()
  {
    if (SpaceGateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpaceGateActivity).a() == -1) {
      super.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     djk
 * JD-Core Version:    0.7.0.1
 */