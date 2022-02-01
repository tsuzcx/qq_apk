import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class atjz
  extends atjr
{
  protected boolean dhW;
  
  public atjz(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  public void VB(boolean paramBoolean)
  {
    this.dhW = paramBoolean;
  }
  
  public View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    label163:
    atin localatin;
    long l;
    Object localObject2;
    Object localObject1;
    byte[] arrayOfByte;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131558964, paramViewGroup, false);
      paramViewGroup = new atjz.a(null);
      paramViewGroup.g = ((AsyncImageView)paramView.findViewById(2131364710));
      paramViewGroup.aeL = ((TextView)paramView.findViewById(2131364718));
      paramViewGroup.aeM = ((TextView)paramView.findViewById(2131364717));
      paramViewGroup.aeN = ((TextView)paramView.findViewById(2131364707));
      paramViewGroup.ab = ((CheckBox)paramView.findViewById(2131369420));
      paramViewGroup.EY = paramView.findViewById(2131364809);
      paramViewGroup.aeO = ((TextView)paramView.findViewById(2131364716));
      paramView.setTag(paramViewGroup);
      if (!paramBoolean1) {
        break label479;
      }
      if (this.mode != 0) {
        break label466;
      }
      paramViewGroup.ab.setVisibility(0);
      paramViewGroup.ab.setChecked(paramBoolean2);
      paramViewGroup.aeN.setVisibility(4);
      localatin = (atin)paramatiu;
      paramViewGroup.g.setImageResource(2130839379);
      paramViewGroup.aeL.setText(localatin.name);
      l = localatin.getSortTime();
      if ((!this.dhW) || (localatin.getCloudFileType() != 1)) {
        break label530;
      }
      localObject2 = (atgc)this.app.getManager(373);
      localObject1 = ((atgc)localObject2).aF();
      arrayOfByte = ((atgc)localObject2).aG();
      localObject2 = localatin.Y();
      if ((!Arrays.equals((byte[])localObject1, (byte[])localObject2)) || (localObject1 == null) || (localObject1.length <= 0)) {
        break label533;
      }
    }
    label399:
    label530:
    label533:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      paramInt1 = paramInt2;
      if (Arrays.equals(arrayOfByte, (byte[])localObject2))
      {
        paramInt1 = paramInt2;
        if (arrayOfByte != null)
        {
          paramInt1 = paramInt2;
          if (arrayOfByte.length > 0) {
            paramInt1 = 1;
          }
        }
      }
      localObject1 = this.context.getString(2131691584);
      if (localObject2 != null)
      {
        paramInt2 = paramInt1;
        if (localObject2.length != 0) {}
      }
      else
      {
        paramInt2 = paramInt1;
        if (((String)localObject1).equalsIgnoreCase(localatin.name)) {
          paramInt2 = 1;
        }
      }
      if (paramInt2 == 0) {
        l = localatin.getCreateTime();
      }
      for (;;)
      {
        if (l == 0L)
        {
          paramViewGroup.aeM.setVisibility(8);
          paramViewGroup.aeO.setVisibility(8);
          paramViewGroup.a = paramatiu;
          paramViewGroup.isSelected = paramBoolean2;
          paramViewGroup.checkBox = paramViewGroup.ab;
          if (paramatiu.isClickable()) {
            break label517;
          }
          paramViewGroup.EY.setVisibility(0);
        }
        for (;;)
        {
          paramView.setOnClickListener(paramOnClickListener);
          paramView.setOnLongClickListener(paramOnLongClickListener);
          return paramView;
          paramViewGroup = (atjz.a)paramView.getTag();
          break;
          label466:
          paramViewGroup.ab.setVisibility(8);
          break label163;
          label479:
          paramViewGroup.ab.setVisibility(8);
          break label163;
          paramViewGroup.aeM.setVisibility(0);
          paramViewGroup.aeM.setText(auqb.bG(l));
          break label399;
          paramViewGroup.EY.setVisibility(8);
        }
      }
    }
  }
  
  public List<atiw> a(atiu paramatiu)
  {
    paramatiu = new ArrayList();
    paramatiu.add(e);
    paramatiu.add(c);
    paramatiu.add(b);
    return paramatiu;
  }
  
  public void destroy() {}
  
  public List<atiw> gt()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(e);
    localArrayList.add(c);
    localArrayList.add(b);
    return localArrayList;
  }
  
  class a
    extends atjv.a
  {
    View EY;
    CheckBox ab;
    TextView aeL;
    TextView aeM;
    TextView aeN;
    TextView aeO;
    AsyncImageView g;
    
    private a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjz
 * JD-Core Version:    0.7.0.1
 */