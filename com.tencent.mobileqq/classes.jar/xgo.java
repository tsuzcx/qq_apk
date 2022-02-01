import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class xgo
  extends xgl
{
  public final int a;
  public ArrayList<WeakReference<xgr>> a;
  protected ConcurrentHashMap<String, Boolean> a;
  public xgt a;
  
  public xgo(xgt paramxgt)
  {
    super(paramxgt);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Xgt = paramxgt;
    paramxgt = this.jdField_a_of_type_Xgt.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Xgt.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramxgt != null)
    {
      paramxgt = paramxgt.iterator();
      while (paramxgt.hasNext())
      {
        String str = (String)paramxgt.next();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    xgq localxgq = new xgq();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(str);
      }
    }
    localxgq.jdField_a_of_type_Boolean = true;
    localxgq.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    ykq.b("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + localxgq.jdField_a_of_type_JavaUtilArrayList.toString());
    wad.a().dispatch(localxgq);
    this.jdField_a_of_type_Xgt.a().finish();
  }
  
  public void a(xgr paramxgr)
  {
    super.a(paramxgr);
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramxgr));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(xgr paramxgr, int paramInt1, int paramInt2, xhf paramxhf)
  {
    super.a(paramxgr, paramInt1, paramInt2, paramxhf);
    paramxhf = paramxhf.a;
    if (TextUtils.isEmpty(paramxhf)) {
      return;
    }
    ImageView localImageView = (ImageView)paramxgr.jdField_a_of_type_AndroidViewView.findViewById(2131368599);
    localImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramxhf)) && (((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramxhf)).booleanValue()))
    {
      localImageView.setImageResource(2130844690);
      paramxhf = (TextView)paramxgr.jdField_a_of_type_AndroidViewView.findViewById(2131378823);
      paramxhf.setVisibility(0);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label155;
      }
      paramxgr = anvx.a(2131713227);
      label118:
      paramxhf.setText(paramxgr);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramxhf.setEnabled(bool);
      return;
      localImageView.setImageResource(2130845670);
      break;
      paramxgr = anvx.a(2131713230) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break label118;
    }
  }
  
  public void a(xgr paramxgr, View paramView)
  {
    super.a(paramxgr, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368599: 
      paramxgr = paramxgr.jdField_a_of_type_Xhf.a;
      zdl.a(paramxgr);
      label87:
      TextView localTextView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramxgr))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramxgr);
        ((ImageView)paramView).setImageResource(2130845670);
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramxgr = (xgr)((WeakReference)paramView.next()).get();
        } while (paramxgr == null);
        localTextView = (TextView)paramxgr.jdField_a_of_type_AndroidViewView.findViewById(2131378823);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label285;
        }
        paramxgr = anvx.a(2131713229);
        label147:
        localTextView.setText(paramxgr);
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label323;
        }
      }
      label285:
      label323:
      for (boolean bool = true;; bool = false)
      {
        localTextView.setEnabled(bool);
        break label87;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= this.jdField_a_of_type_Int)
        {
          paramxgr = bhdj.a(this.jdField_a_of_type_Xgt.a(), 230);
          paramxgr.setMessage(String.format(anvx.a(2131713232), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), vzh.a }));
          paramxgr.setPositiveButton(anvx.a(2131713226), new xgp(this));
          paramxgr.show();
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramxgr, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130844690);
        break;
        paramxgr = anvx.a(2131713225) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
        break label147;
      }
    }
    a();
  }
  
  public void a(xgr paramxgr, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramxgr.jdField_a_of_type_AndroidViewView.findViewById(2131378823);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      paramxgr = anvx.a(2131713228);
      localTextView.setText(paramxgr);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramxgr = anvx.a(2131713231) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgo
 * JD-Core Version:    0.7.0.1
 */