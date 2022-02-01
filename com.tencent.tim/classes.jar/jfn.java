import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.av.ui.VoiceChangeItemView1;
import com.tencent.av.ui.VoiceChangeItemView1.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jfn
  extends BaseAdapter
{
  public static String TAG = "VoiceChangeAdapter";
  VoiceChangeItemView1.a jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$a;
  private VoiceChangeItemView1 jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1;
  private jfp.a[] jdField_a_of_type_ArrayOfJfp$a;
  private int ayA;
  private int ayz;
  private VoiceChangeItemView1 b;
  private Context mContext;
  private int mLastPosition;
  private int mTextColor;
  
  public void a(jfp.a[] paramArrayOfa)
  {
    this.jdField_a_of_type_ArrayOfJfp$a = paramArrayOfa;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfJfp$a == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfJfp$a.length;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfJfp$a == null) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfJfp$a[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    igd.aH(TAG, "getView|position=" + paramInt + ", view=" + paramView);
    if (paramView == null) {
      paramView = new VoiceChangeItemView1(this.mContext);
    }
    for (;;)
    {
      jfp.a locala = (jfp.a)getItem(paramInt);
      VoiceChangeItemView1 localVoiceChangeItemView1;
      if (locala != null)
      {
        if ((this.ayA == 0) && (paramInt == 1) && (this.mLastPosition == 0)) {
          this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = this.b;
        }
        localVoiceChangeItemView1 = (VoiceChangeItemView1)paramView;
        if (this.ayz != locala.type) {
          break label187;
        }
      }
      for (;;)
      {
        localVoiceChangeItemView1.a(paramInt, locala, bool, this.mTextColor, this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$a);
        if (this.ayz == locala.type)
        {
          if (paramInt != 0) {
            this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = localVoiceChangeItemView1;
          }
          this.ayA = paramInt;
        }
        this.b = ((VoiceChangeItemView1)paramView);
        this.mLastPosition = paramInt;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label187:
        bool = false;
      }
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfn
 * JD-Core Version:    0.7.0.1
 */