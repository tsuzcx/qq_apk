import UserGrowth.stFeed;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class uht
  extends RecyclerView.Adapter<uhw>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<uhv> jdField_a_of_type_JavaUtilList;
  private uhz jdField_a_of_type_Uhz;
  
  public uht(Context paramContext, List<uhv> paramList, uhz paramuhz)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Uhz = paramuhz;
  }
  
  private void a(uhv paramuhv, int paramInt)
  {
    stFeed localstFeed;
    HashMap localHashMap;
    String str;
    if (this.jdField_a_of_type_Uhz != null)
    {
      localstFeed = this.jdField_a_of_type_Uhz.a();
      localHashMap = new HashMap();
      localHashMap.put("qq_group_num", paramuhv.c);
      str = unz.a;
      if (localstFeed == null) {
        break label66;
      }
    }
    label66:
    for (paramuhv = localstFeed.feed;; paramuhv = null)
    {
      uns.a("qqgroup_add", paramInt + 1, str, localHashMap, paramuhv);
      return;
    }
  }
  
  public uhw a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560012, paramViewGroup, false);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.height = ((int)paramViewGroup.getContext().getResources().getDimension(2131296549));
    localView.setLayoutParams(localLayoutParams);
    return new uhw(localView);
  }
  
  public void a(uhw paramuhw, int paramInt)
  {
    uhv localuhv = (uhv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    uqt.a(this.jdField_a_of_type_AndroidContentContext, paramuhw.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, localuhv.a());
    paramuhw.jdField_a_of_type_AndroidWidgetTextView.setText(localuhv.b());
    paramuhw.b.setOnClickListener(new uhu(this, localuhv, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramuhw, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uht
 * JD-Core Version:    0.7.0.1
 */