import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class xqi
  extends xqf
{
  public final int a;
  public ArrayList<WeakReference<xql>> a;
  protected ConcurrentHashMap<String, Boolean> a;
  public xqn a;
  
  public xqi(xqn paramxqn)
  {
    super(paramxqn);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Xqn = paramxqn;
    paramxqn = this.jdField_a_of_type_Xqn.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Xqn.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramxqn != null)
    {
      paramxqn = paramxqn.iterator();
      while (paramxqn.hasNext())
      {
        String str = (String)paramxqn.next();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    xqk localxqk = new xqk();
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
    localxqk.jdField_a_of_type_Boolean = true;
    localxqk.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    yuk.b("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + localxqk.jdField_a_of_type_JavaUtilArrayList.toString());
    wjj.a().dispatch(localxqk);
    this.jdField_a_of_type_Xqn.a().finish();
  }
  
  public void a(xql paramxql)
  {
    super.a(paramxql);
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramxql));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(xql paramxql, int paramInt1, int paramInt2, xqz paramxqz)
  {
    super.a(paramxql, paramInt1, paramInt2, paramxqz);
    paramxqz = paramxqz.a;
    if (TextUtils.isEmpty(paramxqz)) {
      return;
    }
    ImageView localImageView = (ImageView)paramxql.jdField_a_of_type_AndroidViewView.findViewById(2131368418);
    localImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramxqz)) && (((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramxqz)).booleanValue()))
    {
      localImageView.setImageResource(2130844748);
      paramxqz = (TextView)paramxql.jdField_a_of_type_AndroidViewView.findViewById(2131378767);
      paramxqz.setVisibility(0);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label155;
      }
      paramxql = anzj.a(2131712648);
      label118:
      paramxqz.setText(paramxql);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramxqz.setEnabled(bool);
      return;
      localImageView.setImageResource(2130845706);
      break;
      paramxql = anzj.a(2131712651) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break label118;
    }
  }
  
  public void a(xql paramxql, View paramView)
  {
    super.a(paramxql, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368418: 
      paramxql = paramxql.jdField_a_of_type_Xqz.a;
      znw.a(paramxql);
      label87:
      TextView localTextView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramxql))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramxql);
        ((ImageView)paramView).setImageResource(2130845706);
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramxql = (xql)((WeakReference)paramView.next()).get();
        } while (paramxql == null);
        localTextView = (TextView)paramxql.jdField_a_of_type_AndroidViewView.findViewById(2131378767);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label285;
        }
        paramxql = anzj.a(2131712650);
        label147:
        localTextView.setText(paramxql);
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
          paramxql = bhlq.a(this.jdField_a_of_type_Xqn.a(), 230);
          paramxql.setMessage(String.format(anzj.a(2131712653), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), win.a }));
          paramxql.setPositiveButton(anzj.a(2131712647), new xqj(this));
          paramxql.show();
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramxql, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130844748);
        break;
        paramxql = anzj.a(2131712646) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
        break label147;
      }
    }
    a();
  }
  
  public void a(xql paramxql, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramxql.jdField_a_of_type_AndroidViewView.findViewById(2131378767);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      paramxql = anzj.a(2131712649);
      localTextView.setText(paramxql);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramxql = anzj.a(2131712652) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqi
 * JD-Core Version:    0.7.0.1
 */