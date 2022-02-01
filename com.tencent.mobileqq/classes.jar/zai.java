import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;

public class zai
  extends yzs
{
  public zai(HorizontalRvInnerView paramHorizontalRvInnerView) {}
  
  public zah a(ViewGroup paramViewGroup, int paramInt)
  {
    if (HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView) != null) {
      return HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView).a(paramViewGroup, paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    if (HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView) != null) {
      return HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView).c();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((!ArrayUtils.isOutOfArrayIndex(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) && (HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView) != null)) {
      HorizontalRvInnerView.a(this.jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView).a(paramViewHolder, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zai
 * JD-Core Version:    0.7.0.1
 */