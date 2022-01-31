import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class wsj
  extends wug
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhcw jdField_a_of_type_Bhcw;
  private wsr jdField_a_of_type_Wsr;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private wsr jdField_b_of_type_Wsr;
  private RecyclerView jdField_c_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private wsr jdField_c_of_type_Wsr;
  private RecyclerView jdField_d_of_type_AndroidSupportV7WidgetRecyclerView;
  private CheckBox jdField_d_of_type_AndroidWidgetCheckBox;
  private wsr jdField_d_of_type_Wsr;
  
  public wsj(Activity paramActivity, View paramView, wus paramwus)
  {
    super(paramActivity, paramView, paramwus);
    this.jdField_a_of_type_Bhcw = ((bhcw)paramwus.a(65537, new Object[0]));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new wsl(this));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new wsm(this));
    this.jdField_c_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new wsn(this));
    this.jdField_d_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new wso(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_Wsr = new wsr(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_Wsr = new wsr(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_Wsr = new wsr(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_d_of_type_Wsr = new wsr(this.jdField_a_of_type_AndroidAppActivity);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Wsr);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_b_of_type_Wsr);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_c_of_type_Wsr);
    localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 1, false);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_d_of_type_Wsr);
  }
  
  private void g()
  {
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_GET_ENV_INFO", null, new wsp(this));
  }
  
  private void j()
  {
    bgxl.a().a(this.jdField_a_of_type_Bhcw, new wsq(this));
  }
  
  protected void a()
  {
    View localView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131296613)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296618));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296619));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131296616));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131296621));
    this.jdField_c_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131296624));
    this.jdField_d_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131296623));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131296615));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131296620));
    this.jdField_c_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131296614));
    this.jdField_d_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131296622));
    e();
    f();
    g();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new wsk(this));
    j();
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Object localObject2;
    Object localObject3;
    if (paramInt == 720897)
    {
      localObject2 = (List)paramVarArgs[0];
      localObject1 = (List)paramVarArgs[1];
      paramVarArgs = new LinkedList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bgxo)((Iterator)localObject2).next();
        localwst = new wst(null);
        localwst.a = wsv.a((bgxo)localObject3);
        paramVarArgs.add(localwst);
      }
      localObject2 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (bgxn)((Iterator)localObject1).next();
        localwst = new wst(null);
        localwst.a = ((bgxn)localObject3).toString();
        ((List)localObject2).add(localwst);
      }
      this.jdField_a_of_type_Wsr.a(paramVarArgs);
      this.jdField_c_of_type_Wsr.a((List)localObject2);
    }
    while (paramInt != 720898)
    {
      wst localwst;
      return;
    }
    Object localObject1 = bgxl.a.a();
    paramVarArgs = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = new wst(null);
      ((wst)localObject3).a = ((CharSequence)localObject2);
      paramVarArgs.add(localObject3);
    }
    this.jdField_d_of_type_Wsr.a(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wsj
 * JD-Core Version:    0.7.0.1
 */