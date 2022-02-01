import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class amlx
  extends amlt
  implements aqdf.a, AbsListView.e
{
  private amus jdField_a_of_type_Amus = new amus();
  private aqdf jdField_a_of_type_Aqdf;
  private AbsListView.e c;
  private boolean cDr;
  public int fromType = -1;
  protected int mScrollState = 0;
  private ListView s;
  
  public amlx(ListView paramListView, aqdf paramaqdf, AbsListView.e parame, int paramInt)
  {
    this.s = paramListView;
    this.jdField_a_of_type_Aqdf = paramaqdf;
    paramaqdf.a(this);
    paramListView.setOnScrollListener(this);
    this.c = parame;
    this.fromType = paramInt;
  }
  
  private amuk a(int paramInt)
  {
    ampv localampv = a(paramInt);
    if (localampv == null) {
      return null;
    }
    if (!(localampv instanceof amuk)) {
      return null;
    }
    return (amuk)localampv;
  }
  
  private void a(int paramInt, View paramView, ampv paramampv)
  {
    if ((paramView == null) || (paramampv == null)) {}
    for (;;)
    {
      return;
      if ((paramampv instanceof amra))
      {
        paramView = (amxz)paramView.getTag(2131381965);
        if ((paramView instanceof amum)) {}
        for (paramView = ((amum)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_Amus.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, ampv paramampv)
  {
    if ((paramView == null) || (paramampv == null)) {
      return false;
    }
    if ((paramampv instanceof amra))
    {
      amxz localamxz = (amxz)paramView.getTag(2131381965);
      paramView = null;
      if ((localamxz instanceof amum)) {
        paramView = ((amum)localamxz).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((amra)paramampv).vY() != paramView.vY()) || (((amra)paramampv).IZ() != paramView.getType())) {
        break label100;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "reuse contentview");
      }
    }
    return true;
    label100:
    return false;
  }
  
  private boolean a(View paramView, ampv paramampv, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (amxz)paramView.getTag(2131381965);
      if (!(paramView instanceof amum)) {
        break label71;
      }
      paramView = (amum)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof amuu)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((amuu)paramView).showDivider(false);
      }
      for (;;)
      {
        if ((paramInt1 < 1) || (paramInt3 != 59))
        {
          label68:
          return paramBoolean;
          label71:
          paramView = null;
          break;
          label76:
          if (paramInt1 == 1)
          {
            localObject = a(paramInt1 - 1);
            if ((!(localObject instanceof ampf)) || (((ampf)localObject).cDQ)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((ampf)localObject).a().eX();; localObject = null)
      {
        if ((paramampv != null) && (localObject != null) && (((List)localObject).contains(paramampv))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((amuu)paramView).showDivider(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof amui)) || (((amui)paramView).Jb() != 1)) {
          break label68;
        }
        return true;
      }
      label203:
      paramView = null;
    }
  }
  
  public void Pp(boolean paramBoolean)
  {
    this.cDr = paramBoolean;
  }
  
  protected amsq a(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 28: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 37: 
    case 43: 
    case 58: 
    default: 
      return new amti(this.jdField_a_of_type_Aqdf);
    case 41: 
      return new amso(this.jdField_a_of_type_Aqdf);
    case 3: 
      return new amte(this.jdField_a_of_type_Aqdf, false);
    case 12: 
      return new amte(this.jdField_a_of_type_Aqdf, true);
    case 57: 
      return new amsj();
    case 0: 
      return new amtj();
    case 49: 
      return new amtc();
    case 15: 
      return new amtj();
    case 2: 
    case 8: 
      return new amsy(this.jdField_a_of_type_Aqdf);
    case 9: 
      return new amtg();
    case 14: 
      return new amtg();
    case 10: 
      return new avjq();
    case 11: 
      return new agnu(this.jdField_a_of_type_Aqdf);
    case 13: 
      return new amsb(this.jdField_a_of_type_Aqdf);
    case 56: 
      return new amsr(this.jdField_a_of_type_Aqdf);
    case 60: 
      return new amsu(this.jdField_a_of_type_Aqdf);
    case 16: 
      return new amti(this.jdField_a_of_type_Aqdf);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new amrv(this.jdField_a_of_type_Aqdf, jd(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new amsk();
    case 38: 
    case 39: 
    case 42: 
    case 44: 
    case 45: 
    case 47: 
    case 48: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 61: 
    case 62: 
      return new amtn(this.jdField_a_of_type_Aqdf, this);
    case 46: 
      return new amsz(this.jdField_a_of_type_Aqdf);
    }
    return new amta(this.jdField_a_of_type_Aqdf, this);
  }
  
  protected amxz a(int paramInt, ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    Object localObject1;
    switch (getItemViewType(paramInt))
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 18: 
    case 20: 
    case 28: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 37: 
    case 43: 
    case 58: 
    default: 
      return new amzj(paramViewGroup, 2131563022);
    case 41: 
      return new amxv(paramViewGroup);
    case 3: 
      return new amzf(paramViewGroup);
    case 12: 
      return new amzd(paramViewGroup);
    case 57: 
      return new amxt(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof ampf)) {
        break;
      }
    }
    for (boolean bool1 = ((ampf)localObject1).awe();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new amzh(paramViewGroup, bool2, bool1);
      return new amzj(paramViewGroup, 2131559838);
      return new amze(paramViewGroup);
      return new amzg(paramViewGroup, 2131563042, 2130846935, -1);
      return new amzg(paramViewGroup, 2131563042, 2130846935, 12);
      return new amzk(paramViewGroup, 2131560036);
      return new amxq(paramViewGroup, 2131563026);
      return new amya(paramViewGroup, 2131563028);
      return new amyc(paramViewGroup, 2131563029);
      return new amxp(paramViewGroup, 2131563075);
      return new amzj(paramViewGroup, 2131563023);
      return new amzj(paramViewGroup, 2131563030);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = amut.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (ampv)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof amra))) {
        ((amra)localObject1).UB(((amuk)localObject2).getType());
      }
      if (localObject2 == null) {
        return new amxt(paramViewGroup);
      }
      return ((amuk)localObject2).a();
      return new amzc(paramViewGroup, jd(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof amrd)) {
        return new amzb(paramViewGroup, ((amrd)localObject1).getLayoutId());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof amqg))
      {
        localObject1 = (amqg)localObject1;
        switch (((amqg)localObject1).IX())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((amqg)localObject1).getLayoutId() + " which is not supported!!!");
        case 2: 
          return new amyd(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 3: 
          return new amyw(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 4: 
          return new amye(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 7: 
          return new amyl(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 6: 
          return new amyv(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 8: 
          return new amyt(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 9: 
          return new amys(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 11: 
          return new amyi(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 12: 
          return new amyg(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 13: 
          return new amyj(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 14: 
          return new amyu(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 15: 
          return new amyr(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 16: 
          return new amyo(paramViewGroup, ((amqg)localObject1).getLayoutId());
        case 17: 
          return new amyp(paramViewGroup, ((amqg)localObject1).getLayoutId());
        }
        return new amyn(paramViewGroup, ((amqg)localObject1).getLayoutId());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new amzk(paramViewGroup, 2131559839);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof amph)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof ampl)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof amnu));
    if (((super.a(paramInt) instanceof ampf)) && (this.fromType != 12))
    {
      if (((ampf)super.a(paramInt)).cDQ) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof ampf)) && (this.fromType == 12))
    {
      if (((ampf)super.a(paramInt)).cDQ) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof ampg))
    {
      ampg localampg = (ampg)super.a(paramInt);
      if ((localampg != null) && (localampg.cDQ)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof ampq)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof amoz)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof ampm)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof ampd)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof ampo)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof ampb)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof amox)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof ampn)) && (this.fromType != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof ampn)) && (this.fromType == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof avju)) {
      return 10;
    }
    if ((a(paramInt) instanceof agnx)) {
      return 11;
    }
    if (((super.a(paramInt) instanceof ampi)) || ((super.a(paramInt) instanceof ampk))) {
      return 13;
    }
    if ((a(paramInt) instanceof ampp)) {
      return 17;
    }
    if ((a(paramInt) instanceof ampj)) {
      return 19;
    }
    if ((a(paramInt) instanceof amra)) {
      return 59;
    }
    if ((a(paramInt) instanceof amow))
    {
      switch (((amow)a(paramInt)).IW())
      {
      default: 
        return 25;
      case 268435456: 
        return 26;
      case 1001: 
        return 21;
      }
      return 22;
    }
    if ((a(paramInt) instanceof amrd))
    {
      switch (((amrd)a(paramInt)).blx)
      {
      case -2: 
      default: 
        return 29;
      case -1: 
        return 29;
      case -3: 
        return 30;
      }
      return 36;
    }
    if ((a(paramInt) instanceof amqg))
    {
      switch (((amqg)a(paramInt)).IX())
      {
      case 5: 
      case 10: 
      default: 
        return 45;
      case 2: 
        return 38;
      case 3: 
        return 39;
      case 4: 
        return 42;
      case 7: 
        return 44;
      case 6: 
        return 45;
      case 8: 
        return 47;
      case 9: 
        return 48;
      case 11: 
        return 50;
      case 12: 
        return 51;
      case 13: 
        return 52;
      case 14: 
        return 53;
      case 15: 
        return 54;
      case 16: 
        return 55;
      case 17: 
        return 61;
      }
      return 62;
    }
    if ((a(paramInt) instanceof amqy)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ampv localampv = a(paramInt);
    Object localObject3;
    int j;
    int i;
    Object localObject6;
    Object localObject7;
    if (amkl.a(localampv) > 0)
    {
      Object localObject1;
      if (amkl.mT.containsKey(localampv))
      {
        localObject1 = (amkl.a)amkl.mT.get(localampv);
        if (!((amkl.a)localObject1).acL)
        {
          ((amkl.a)localObject1).acL = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", amub.zn());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((amkl.a)localObject1).index);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        amub.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((amkl.a)localObject1).ajO + "").obj2(((amkl.a)localObject1).caE).ver1(((amkl.a)localObject1).key).ver2(amub.eZ(this.fromType)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + amkl.ajN));
        ((amkl.a)localObject1).acL = true;
        amkl.mT.put(localampv, localObject1);
        if ((localampv instanceof ampw))
        {
          localObject1 = (ampw)localampv;
          localObject3 = ((ampw)localObject1).eX();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((ampw)localObject1).Ex());
            i = 0;
            if (i < j) {
              if (amkl.mT.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (amkl.a)amkl.mT.get(((List)localObject3).get(i));
                if (!((amkl.a)localObject4).acL)
                {
                  ((amkl.a)localObject4).acL = true;
                  localObject6 = new JSONObject();
                }
              }
            }
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          for (;;)
          {
            Object localObject4;
            ((JSONObject)localObject6).put("project", amub.zn());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((amkl.a)localObject4).index);
            if (!(((List)localObject3).get(i) instanceof amqc)) {
              break label716;
            }
            localObject7 = (amqc)((List)localObject3).get(i);
            if (!((amqc)localObject7).awg()) {
              break;
            }
            localObject1 = "1";
            ((amkl.a)localObject4).caE = ((amqc)localObject7).uU();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            amub.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((amkl.a)localObject4).ajO + "").obj2(((amkl.a)localObject4).caE).ver1(((amkl.a)localObject4).key).ver2(amub.eZ(this.fromType)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + amkl.ajN));
            ((amkl.a)localObject4).acL = true;
            amkl.mT.put(((List)localObject3).get(i), localObject4);
            i += 1;
          }
          localJSONException2 = localJSONException2;
          QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException2);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException1);
            continue;
            localObject2 = "0";
            continue;
            label716:
            localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            amub.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.ajO + "").obj2(localJSONException2.caE).ver1(localJSONException2.key).ver2(amub.eZ(this.fromType)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + amkl.ajN));
            localJSONException2.acL = true;
            amkl.mT.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localampv instanceof amov))
    {
      localObject2 = (amov)localampv;
      if ((((amov)localObject2).eX() != null) && (((amov)localObject2).eX().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((amov)localObject2).eX().size()) {
            break label1809;
          }
          localObject3 = (ampv)((amov)localObject2).eX().get(i);
          if (amkl.mT.containsKey(localObject3))
          {
            localObject3 = (amkl.a)amkl.mT.get(localObject3);
            if (!((amkl.a)localObject3).acL)
            {
              ((amkl.a)localObject3).acL = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", amub.zn());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((amkl.a)localObject3).index);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            amub.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((amkl.a)localObject3).ajO + "").obj2(((amkl.a)localObject3).caE).ver1(((amkl.a)localObject3).key).ver2(amub.eZ(this.fromType)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + amkl.ajN));
            i += 1;
          }
          catch (JSONException localJSONException4)
          {
            for (;;)
            {
              QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException4);
            }
          }
        }
      }
    }
    else if ((localampv instanceof amqm))
    {
      localObject2 = ((amqm)localampv).zA;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (amql)((Iterator)localObject2).next();
          if (amkl.mT.containsKey(localObject3))
          {
            localObject5 = (amkl.a)amkl.mT.get(localObject3);
            if (!((amkl.a)localObject5).acL)
            {
              ((amkl.a)localObject5).acL = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", amub.zn());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((amkl.a)localObject5).index);
                localJSONObject.put("extra_info", ((amql)localObject3).cbP);
                localJSONObject.put("tepl", ((amql)localObject3).cbB);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                amub.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((amql)localObject3).ajO + "").obj2(((amql)localObject3).cbr).ver1(((amkl.a)localObject5).key).ver2(amub.eZ(this.fromType)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + amkl.ajN));
              }
              catch (JSONException localJSONException5)
              {
                for (;;)
                {
                  QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException5);
                }
              }
            }
          }
        }
      }
    }
    else
    {
      if (!(localampv instanceof amqp)) {
        break label2272;
      }
      if (amkl.mT.containsKey(localampv))
      {
        localObject2 = (amkl.a)amkl.mT.get(localampv);
        localObject3 = (amqp)localampv;
        if (!((amkl.a)localObject2).acL)
        {
          ((amkl.a)localObject2).acL = true;
          localObject5 = new StringBuilder();
          if ((((amqp)localObject3).Ge != null) && (((amqp)localObject3).Ge.size() > 0))
          {
            i = 0;
            if (i < ((amqp)localObject3).Ge.size())
            {
              if (i != ((amqp)localObject3).Ge.size() - 1) {
                ((StringBuilder)localObject5).append(((amqd)((amqp)localObject3).Ge.get(i)).desc).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((amqd)((amqp)localObject3).Ge.get(i)).desc);
              }
            }
          }
          amub.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((amkl.a)localObject2).key).ver2(amub.eZ(this.fromType)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + amub.cce + "}"));
        }
      }
    }
    label1809:
    if (amkl.mS.containsKey(localampv))
    {
      localObject2 = (amkl.a)amkl.mS.get(localampv);
      if (!((amkl.a)localObject2).acL)
      {
        if (amxk.cF(((amkl.a)localObject2).ajO))
        {
          if (!((amkl.a)localObject2).cDd) {
            break label2889;
          }
          i = 2;
          label1863:
          amxk.e("all_result", "exp_object", i, 0, new String[] { ((amkl.a)localObject2).key, ((amkl.a)localObject2).ajO + "", ((amkl.a)localObject2).caE, ((amkl.a)localObject2).index + "" });
          ((amkl.a)localObject2).acL = true;
          amkl.mS.put((ampx)localampv, localObject2);
        }
        if ((localampv instanceof amrd))
        {
          localObject3 = (amrd)localampv;
          if ((((amrd)localObject3).blx == -3) || (((amrd)localObject3).blx == -4))
          {
            if (!((amkl.a)localObject2).cDd) {
              break label2895;
            }
            i = 2;
            label2015:
            amxk.e("all_result", "exp_net_search", i, 0, new String[] { ((amkl.a)localObject2).key, ((amkl.a)localObject2).ajO + "", ((amkl.a)localObject2).caE, ((amkl.a)localObject2).index + "" });
          }
        }
      }
    }
    Object localObject2 = paramView;
    if (!a(paramView, localampv)) {
      localObject2 = null;
    }
    paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
    a(paramInt, paramView, localampv);
    boolean bool1 = false;
    if (paramInt == 0) {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (paramInt >= 1)
    {
      i = getItemViewType(paramInt);
      j = getItemViewType(paramInt - 1);
      if (i != 11)
      {
        bool2 = bool1;
        if (i != 10) {}
      }
      else if (j != 11)
      {
        bool2 = bool1;
        if (j != 10) {}
      }
      else
      {
        bool2 = true;
      }
      bool2 = a(paramView, localampv, paramInt, i, j, bool2);
    }
    if ((paramView != null) && (paramView.findViewById(2131366004) != null))
    {
      if (!bool2) {
        break label2901;
      }
      paramView.findViewById(2131366004).setVisibility(8);
    }
    for (;;)
    {
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
        return paramView;
        label2272:
        if (((!(localampv instanceof amqg)) || ((localampv instanceof amqt))) && (((!(localampv instanceof amow)) && ((!(localampv instanceof amrd)) || (((amrd)localampv).blx != -4))) || (!amkl.mT.containsKey(localampv)))) {
          break;
        }
        localObject2 = (amkl.a)amkl.mT.get(localampv);
        if ((localampv instanceof amqq))
        {
          localObject3 = (amqq)localampv;
          if (!((amkl.a)localObject2).acL)
          {
            ((amkl.a)localObject2).acL = true;
            localObject5 = new StringBuilder();
            if ((((amqq)localObject3).Ge != null) && (((amqq)localObject3).Ge.size() > 0))
            {
              i = 0;
              while (i < ((amqq)localObject3).Ge.size())
              {
                ((StringBuilder)localObject5).append(((amqz)((amqq)localObject3).Ge.get(i)).word).append("::");
                i += 1;
              }
              amub.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((amkl.a)localObject2).key).ver2(amub.eZ(this.fromType)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + amub.cce + "}"));
            }
            amub.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((amkl.a)localObject2).key).ver2(amub.eZ(this.fromType)).ver5("2").ver7("{experiment_id:" + amub.cce + "}"));
          }
        }
        if (((amkl.a)localObject2).acL) {
          break;
        }
        ((amkl.a)localObject2).acL = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", amub.zn());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((amkl.a)localObject2).index);
          if ((localampv instanceof amqg)) {
            ((JSONObject)localObject3).put("tepl", ((amqg)localampv).cbB);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          amub.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((amkl.a)localObject2).ajO + "").obj2(((amkl.a)localObject2).caE).ver1(((amkl.a)localObject2).key).ver2(amub.eZ(this.fromType)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + amkl.ajN));
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException3);
          }
        }
      }
      label2889:
      i = 1;
      break label1863;
      label2895:
      i = 1;
      break label2015;
      label2901:
      paramView.findViewById(2131366004).setVisibility(0);
    }
  }
  
  public int getViewTypeCount()
  {
    return 63;
  }
  
  public int jd(int paramInt)
  {
    if ((a(paramInt) instanceof amov)) {
      return ((amov)a(paramInt)).IV();
    }
    if ((a(paramInt) instanceof amow)) {
      return ((amow)a(paramInt)).IW();
    }
    return 0;
  }
  
  public void notifyDataSetChanged()
  {
    int i1 = getCount();
    int n = 0;
    int j = 0;
    int k = 0;
    int i = 0;
    if (n < i1)
    {
      Object localObject = a(n);
      int m;
      if ((localObject instanceof ampf))
      {
        localObject = (ampf)localObject;
        k = i + 1;
        ((ampf)localObject).iv(1, k);
        i = j;
        if (((ampf)localObject).getGroupType() == 2) {
          i = j + 1;
        }
        ((ampf)localObject).iv(3, i);
        ((ampf)localObject).aZ(0, k, i);
        m = 0;
        j = k;
        k = i;
        i = m;
      }
      for (;;)
      {
        n += 1;
        m = j;
        j = k;
        k = i;
        i = m;
        break;
        if ((localObject instanceof amrc))
        {
          localObject = (amrc)localObject;
          k += 1;
          ((amrc)localObject).aZ(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof amow))
          {
            localObject = (amow)localObject;
            m = k + 1;
            ((amow)localObject).aZ(m, i, j);
          }
          k = m;
          m = i;
          i = k;
          k = j;
          j = m;
        }
      }
    }
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_Aqdf.isPausing() + ", mScrollState : " + this.mScrollState);
    }
    if ((!this.jdField_a_of_type_Aqdf.isPausing()) && ((this.mScrollState == 0) || (this.mScrollState == 1)))
    {
      int j = this.s.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.s.getChildAt(paramInt1);
        ampu localampu;
        amsp localamsp;
        amxw localamxw;
        if (((localView.getTag(2131381960) instanceof ampu)) && ((localView.getTag(2131381962) instanceof amsp)) && ((localView.getTag(2131381965) instanceof amxw)))
        {
          localampu = (ampu)localView.getTag(2131381960);
          localamsp = (amsp)localView.getTag(2131381962);
          localamxw = (amxw)localView.getTag(2131381965);
          if ((localampu.pG() == paramInt2) && (paramString.equals(localampu.getUin()))) {
            localamsp.a(localampu, localamxw, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localampu = (ampu)((ViewGroup)localView).getChildAt(i).getTag(2131381960);
            if ((localampu != null) && (localampu.pG() == paramInt2) && (paramString.equals(localampu.getUin())))
            {
              localamsp = (amsp)((ViewGroup)localView).getChildAt(i).getTag(2131381962);
              localamxw = (amxw)((ViewGroup)localView).getChildAt(i).getTag(2131381965);
              if ((localamsp != null) && (localamxw != null)) {
                localamsp.a(localampu, localamxw, paramBitmap);
              }
            }
            i += 1;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.c != null) {
      this.c.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Amus.ba(paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.s == null) {
      return;
    }
    this.mScrollState = paramInt;
    int k;
    int i;
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.jdField_a_of_type_Aqdf.isPausing()) {
        this.jdField_a_of_type_Aqdf.resume();
      }
      k = this.s.getChildCount();
      i = 0;
    }
    while (i < k)
    {
      View localView = this.s.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        int j = 0;
        while (j < ((ViewGroup)localView).getChildCount())
        {
          ampu localampu = (ampu)((ViewGroup)localView).getChildAt(j).getTag(2131381960);
          amsp localamsp = (amsp)((ViewGroup)localView).getChildAt(j).getTag(2131381962);
          amxw localamxw = (amxw)((ViewGroup)localView).getChildAt(j).getTag(2131381965);
          if ((localamsp != null) && (localampu != null) && (paramAbsListView != null)) {
            localamsp.a(localampu, localamxw);
          }
          j += 1;
        }
      }
      i += 1;
      continue;
      this.jdField_a_of_type_Aqdf.edu();
      this.jdField_a_of_type_Aqdf.pause();
    }
    if (this.c != null) {
      this.c.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_Amus.setScrollState(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amlx
 * JD-Core Version:    0.7.0.1
 */