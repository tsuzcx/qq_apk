import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class znd
  extends RecyclerView.ViewHolder
{
  private aklg jdField_a_of_type_Aklg;
  private aknp jdField_a_of_type_Aknp;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  public uaq a;
  private boolean jdField_a_of_type_Boolean;
  
  public znd(View paramView, aklg paramaklg, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
  {
    super(paramView);
    this.jdField_a_of_type_Aklg = paramaklg;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Aknp = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377148));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377153));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131377156));
  }
  
  private void a(View paramView, uaq paramuaq)
  {
    if (TextUtils.equals(paramuaq.jdField_a_of_type_JavaLangString, axil.jdField_a_of_type_JavaLangString))
    {
      axin.a(paramView.getContext(), paramuaq.jdField_a_of_type_JavaLangString, 1);
      return;
    }
    b(paramView, paramuaq);
  }
  
  private boolean a(uaq paramuaq1, uaq paramuaq2)
  {
    if ((paramuaq1 != null) && (paramuaq2 != null)) {
      if ((!paramuaq1.jdField_a_of_type_JavaLangString.equals(paramuaq2.jdField_a_of_type_JavaLangString)) || (paramuaq1.b != paramuaq2.b) || (paramuaq1.jdField_a_of_type_Int != paramuaq2.jdField_a_of_type_Int) || (!paramuaq1.c.equals(paramuaq2.c))) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(ServiceFolderFollowPBHeadView.a(), 4, "isSameServiceData:" + bool);
      return false;
    }
  }
  
  private void b(View paramView, uaq paramuaq)
  {
    Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", paramuaq.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", paramuaq.c);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", paramuaq.b);
    localIntent.putExtra("INTENT_KEY_FROM", 2);
    paramView.getContext().startActivity(localIntent);
  }
  
  @RequiresApi(api=8)
  public void a(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null) {
      paramImageView.setImageDrawable(this.jdField_a_of_type_Aklg.a(1008, paramString));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        paramImageView.setColorFilter(1711276032);
      }
      return;
      paramImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void a(uaq paramuaq, int paramInt)
  {
    if ((paramuaq == null) || (a(this.jdField_a_of_type_Uaq, paramuaq))) {
      return;
    }
    this.jdField_a_of_type_Uaq = paramuaq;
    this.itemView.setTag(this.jdField_a_of_type_Uaq);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377150, this.jdField_a_of_type_Uaq);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377148, Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramuaq.c);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
    }
    a(this.jdField_a_of_type_ComTencentImageURLImageView, paramuaq.jdField_a_of_type_JavaLangString);
    int j = paramuaq.b;
    int i = 0;
    int k = 0;
    int m = paramuaq.jdField_a_of_type_Int;
    Object localObject = paramuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject != null)
    {
      localObject = anxs.a(j + "", ((MessageRecord)localObject).msgseq + "", ((MessageRecord)localObject).msgBackupMsgRandom + "");
      if (j <= 0) {
        break label491;
      }
      if (m != 0) {
        break label421;
      }
      i = 0;
      k = 0;
      j = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, this.itemView);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
    }
    for (;;)
    {
      bjpg.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
      String str2 = "";
      String str1 = str2;
      if (paramuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        str1 = str2;
        if (paramuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
          str1 = paramuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
        }
      }
      this.itemView.setOnClickListener(new zne(this, paramuaq, paramInt, str1, (String)localObject));
      anxs.a(null, paramuaq.jdField_a_of_type_JavaLangString, paramuaq.jdField_a_of_type_Int, paramuaq.b, paramuaq.jdField_a_of_type_JavaLangCharSequence.toString(), str1, (String)localObject, paramInt + "");
      zxp.a(paramuaq.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", paramuaq.c, paramuaq.jdField_a_of_type_JavaLangCharSequence.toString() });
      return;
      localObject = "";
      break;
      label421:
      if (m == 2)
      {
        i = 1;
        k = 0;
        j = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
      }
      else
      {
        i = 3;
        k = 2130850325;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Aknp);
        continue;
        label491:
        j = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znd
 * JD-Core Version:    0.7.0.1
 */