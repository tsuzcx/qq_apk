import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ammz
  extends Handler
{
  public ammz(GroupSearchFragment paramGroupSearchFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    label1170:
    label3605:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search START_SEARCH keyword = " + this.this$0.keyword);
      }
      if (!TextUtils.isEmpty(this.this$0.keyword))
      {
        this.this$0.Hb.setVisibility(8);
        this.this$0.showLoading();
        this.this$0.Id(this.this$0.keyword);
        if (QLog.isColorLevel())
        {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment onViewCreated  startSearch");
          return;
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search GET_LOCAL_MSG");
          this.this$0.lastUpdateTime = System.currentTimeMillis();
          this.this$0.jdField_a_of_type_Amlt.cS(this.this$0.rc);
          if ((this.this$0.rc != null) && (!this.this$0.rc.isEmpty()))
          {
            this.this$0.hideLoading();
            this.this$0.Hb.setVisibility(0);
            return;
            QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search FINISH_LOCAL_MSG");
            if ((this.this$0.rc != null) && (!this.this$0.rc.isEmpty()))
            {
              this.this$0.hideLoading();
              this.this$0.Hb.setVisibility(8);
              this.this$0.Jp(false);
            }
            this.this$0.Ps(false);
            this.this$0.jdField_a_of_type_Amlt.cS(this.this$0.rc);
            return;
            QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search FINISH_NET_MSG");
            if ((this.this$0.rc != null) && (!this.this$0.rc.isEmpty()))
            {
              this.this$0.hideLoading();
              this.this$0.Hb.setVisibility(0);
              this.this$0.Jp(false);
            }
            this.this$0.Ps(false);
            this.this$0.jdField_a_of_type_Amlt.cS(this.this$0.rc);
            if (this.this$0.rc == null) {}
            int k;
            int j;
            for (int i = 0;; i = this.this$0.rc.size())
            {
              k = i;
              if (i > 2) {
                break;
              }
              k = i;
              if (this.this$0.rc == null) {
                break;
              }
              j = 0;
              for (;;)
              {
                k = i;
                if (j >= this.this$0.rc.size()) {
                  break;
                }
                k = i;
                if ((this.this$0.rc.get(j) instanceof amrd)) {
                  k = i - 1;
                }
                j += 1;
                i = k;
              }
            }
            if (k <= 0)
            {
              amxk.b("all_result", "noresult_local", new String[] { "" + this.this$0.keyword });
              return;
              paramMessage = (List)paramMessage.obj;
              QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleMessage, log for search GET_LOCAL_CALLBACK_ON_UPDATE, onUpdate ");
              if ((paramMessage != null) && (paramMessage.size() != 0))
              {
                if (System.currentTimeMillis() - this.this$0.ajS < 500L)
                {
                  this.this$0.ajS = System.currentTimeMillis();
                  return;
                }
                this.this$0.ajS = System.currentTimeMillis();
                if (this.this$0.rc != null) {
                  this.this$0.rc.clear();
                }
                long l;
                for (;;)
                {
                  this.this$0.rc.addAll(paramMessage);
                  if ((this.this$0.b != null) && (!this.this$0.rc.contains(this.this$0.b)))
                  {
                    this.this$0.rc.add(this.this$0.b);
                    this.this$0.b.cbY = this.this$0.keyword;
                  }
                  l = System.currentTimeMillis();
                  if (l - this.this$0.lastUpdateTime < 50L) {
                    break;
                  }
                  this.this$0.mHandler.removeMessages(10);
                  this.this$0.mHandler.sendEmptyMessage(10);
                  return;
                  this.this$0.rc = new ArrayList();
                }
                this.this$0.mHandler.removeMessages(10);
                this.this$0.mHandler.sendEmptyMessageDelayed(10, 50L - (l - this.this$0.lastUpdateTime));
                return;
                Object localObject1 = (List)paramMessage.obj;
                int m = paramMessage.arg1;
                boolean bool1;
                if ((m == 4) || (m == 5))
                {
                  bool1 = true;
                  label876:
                  QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleMessage log for search , GET_LOCAL_CALLBACK_ON_FINISH, onFinish  status = " + m + " isFinish" + bool1);
                  if (localObject1 != null) {
                    break label3601;
                  }
                }
                label1095:
                label1888:
                label2543:
                label3574:
                Object localObject2;
                for (paramMessage = new ArrayList();; paramMessage = localObject2)
                {
                  if ((paramMessage.size() == 0) && (!bool1)) {
                    break label3605;
                  }
                  if ((System.currentTimeMillis() - this.this$0.ajS < 500L) && (!bool1))
                  {
                    this.this$0.ajS = System.currentTimeMillis();
                    return;
                    bool1 = false;
                    break label876;
                  }
                  this.this$0.ajS = System.currentTimeMillis();
                  this.this$0.rc = paramMessage;
                  Object localObject3;
                  Object localObject4;
                  Object localObject5;
                  if (bool1)
                  {
                    if ((GroupSearchFragment.a(this.this$0) != 21) || (amkd.IP() != 0))
                    {
                      i = 0;
                      if (i >= this.this$0.rc.size()) {
                        break label3586;
                      }
                      if ((this.this$0.rc.get(i) instanceof amph))
                      {
                        localObject3 = (amph)this.this$0.rc.get(i);
                        localObject1 = (ampf)this.this$0.rc.get(i - 1);
                        i = 0;
                      }
                    }
                    for (;;)
                    {
                      if (i < this.this$0.rc.size())
                      {
                        if ((this.this$0.rc.get(i) instanceof ampm))
                        {
                          localObject4 = (ampm)this.this$0.rc.get(i);
                          localObject5 = (ampf)this.this$0.rc.get(i - 1);
                          this.this$0.rc.remove(localObject1);
                          this.this$0.rc.remove(localObject3);
                          this.this$0.rc.remove(localObject4);
                          this.this$0.rc.remove(localObject5);
                          k = 0;
                          j = 0;
                          i = -1;
                          while (j < paramMessage.size())
                          {
                            amub.a(paramMessage.get(j), this.this$0.keyword, GroupSearchFragment.a(this.this$0));
                            if (!(paramMessage.get(j) instanceof ampo)) {
                              break label3574;
                            }
                            i = j;
                            if ((paramMessage.get(j) instanceof ampi)) {
                              k = j + 1;
                            }
                            if ((paramMessage.get(j) instanceof ampk)) {
                              k = j + 1;
                            }
                            j += 1;
                          }
                          i += 1;
                          break;
                        }
                        i += 1;
                        continue;
                        this.this$0.jdField_a_of_type_Amrd.cbY = this.this$0.keyword;
                        if ((k == 0) && (i >= 0))
                        {
                          j = i + 1;
                          this.this$0.rc.add(j, this.this$0.jdField_a_of_type_Amrd);
                          j += 1;
                        }
                        for (;;)
                        {
                          amxk.b("all_result", "exp_people_group", new String[] { this.this$0.keyword });
                          amub.a(null, 0, GroupSearchFragment.a(this.this$0), "0X8009D3E", 0, 0, null, null);
                          if ((localObject3 == null) || (((amph)localObject3).eX() == null) || (((amph)localObject3).eX().size() <= 0)) {
                            break label1920;
                          }
                          localObject4 = new StringBuilder();
                          k = 1;
                          while (k < ((amph)localObject3).eX().size() - 1)
                          {
                            ((amow)((amph)localObject3).eX().get(k)).position = (k - 1);
                            k += 1;
                          }
                          this.this$0.rc.add(k, this.this$0.jdField_a_of_type_Amrd);
                          j = k + 1;
                        }
                        int n = Math.min(((amph)localObject3).eX().size(), ((amph)localObject3).Ex());
                        if (n > 0)
                        {
                          k = 0;
                          while (k < n - 1)
                          {
                            localObject5 = (amow)((amph)localObject3).eX().get(k);
                            ((StringBuilder)localObject4).append(((amow)localObject5).id + "::");
                            k += 1;
                          }
                          localObject5 = (amow)((amph)localObject3).eX().get(n - 1);
                          ((StringBuilder)localObject4).append(((amow)localObject5).id + "");
                        }
                        if (((amow)((amph)localObject3).eX().get(0)).name.equals(this.this$0.keyword)) {
                          if (i < 0)
                          {
                            this.this$0.rc.add(0, localObject1);
                            this.this$0.rc.add(1, localObject3);
                            amxk.b("all_result", "exp_function", new String[] { "" + this.this$0.keyword, "" + ((StringBuilder)localObject4).toString(), "", "1" });
                            localObject3 = ((amow)((amph)localObject3).eX().get(0)).getUin();
                            amub.a(null, 0, GroupSearchFragment.a(this.this$0), "0X8009D34", 0, 0, (String)localObject3, null);
                            if (this.this$0.rc.size() >= 2) {}
                            if ((localObject1 != null) && (((ampf)localObject1).awe())) {
                              amub.a(null, 0, GroupSearchFragment.a(this.this$0), "0X8009D4A", 0, 0, null, null);
                            }
                            if (this.this$0.dCV != 6) {
                              break label2340;
                            }
                            this.this$0.dyI = 0;
                            if (this.this$0.dCV != 0) {
                              break label2322;
                            }
                            paramMessage = paramMessage.iterator();
                          }
                        }
                        for (;;)
                        {
                          label1957:
                          if (!paramMessage.hasNext()) {
                            break label2322;
                          }
                          localObject1 = paramMessage.next();
                          if (((localObject1 instanceof avju)) || ((localObject1 instanceof agnx)) || ((localObject1 instanceof ampi)) || ((localObject1 instanceof ampp)) || ((localObject1 instanceof ampk)) || ((localObject1 instanceof ampl)) || ((localObject1 instanceof amnu)) || (((localObject1 instanceof amow)) && (((amow)localObject1).IW() == 268435456)))
                          {
                            if ((localObject1 instanceof ampw))
                            {
                              localObject1 = (ampw)localObject1;
                              if ((localObject1 == null) || (((ampw)localObject1).eX() == null)) {}
                              for (i = 0;; i = ((ampw)localObject1).eX().size())
                              {
                                localObject3 = this.this$0;
                                j = ((GroupSearchFragment)localObject3).dyI;
                                ((GroupSearchFragment)localObject3).dyI = (Math.min(i, ((ampw)localObject1).Ex()) + j);
                                break label1957;
                                this.this$0.rc.add(i + 1, localObject1);
                                this.this$0.rc.add(i + 2, localObject3);
                                break;
                                this.this$0.rc.add(j, localObject1);
                                this.this$0.rc.add(j + 1, localObject3);
                                amxk.b("all_result", "exp_function", new String[] { "" + this.this$0.keyword, "" + ((StringBuilder)localObject4).toString(), "", "0" });
                                amub.a(null, 0, GroupSearchFragment.a(this.this$0), "0X8009D48", 0, 0, null, null);
                                break label1888;
                              }
                            }
                            localObject1 = this.this$0;
                            ((GroupSearchFragment)localObject1).dyI += 1;
                          }
                        }
                        paramMessage = this.this$0;
                        if (m == 4)
                        {
                          i = 1;
                          label2335:
                          paramMessage.dCU = i;
                          label2340:
                          boolean bool2 = false;
                          if ((this.this$0.getActivity() instanceof amkf)) {
                            bool2 = ((amkf)this.this$0.getActivity()).avZ();
                          }
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "onFinish(). matchCount=" + this.this$0.dyI + " forceRequestStatus=" + this.this$0.dCV);
                          }
                          if (UniteSearchActivity.bi(GroupSearchFragment.b(this.this$0), GroupSearchFragment.a(this.this$0))) {
                            break label2881;
                          }
                          if (this.this$0.dCV == 0) {
                            this.this$0.dCV = 4;
                          }
                          label2465:
                          if (bool2) {
                            break label2907;
                          }
                          paramMessage = this.this$0;
                          if (m != 5) {
                            break label2902;
                          }
                          i = 4;
                          label2483:
                          paramMessage.dCU = i;
                          this.this$0.dOm();
                          i = 12;
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    label2498:
                    l = System.currentTimeMillis();
                    if (l - this.this$0.lastUpdateTime >= 50L)
                    {
                      this.this$0.mHandler.removeMessages(i);
                      this.this$0.mHandler.sendEmptyMessage(i);
                      if (!bool1) {
                        break label2951;
                      }
                      j = 0;
                      i = j;
                      if (this.this$0.rc == null) {
                        break label3389;
                      }
                      i = j;
                      if (this.this$0.rc.size() <= 0) {
                        break label3389;
                      }
                      paramMessage = this.this$0.rc.iterator();
                      i = 0;
                      j = 0;
                      if (!paramMessage.hasNext()) {
                        break label3387;
                      }
                      localObject1 = paramMessage.next();
                      if ((!(localObject1 instanceof avju)) && (!(localObject1 instanceof agnx))) {
                        break label2953;
                      }
                      j += 1;
                      localObject3 = new amkl.a();
                      k = i + 1;
                      ((amkl.a)localObject3).index = k;
                      ((amkl.a)localObject3).ajO = amkl.a((ampw)localObject1);
                      ((amkl.a)localObject3).key = ((ampw)localObject1).getKeyword();
                      amkl.mT.put((ampw)localObject1, localObject3);
                      i = j;
                      j = k;
                    }
                    for (;;)
                    {
                      k = j;
                      if ((localObject1 instanceof amrd))
                      {
                        k = j;
                        if (((amrd)localObject1).blx == -1)
                        {
                          localObject3 = new amkl.a();
                          k = j + 1;
                          ((amkl.a)localObject3).index = k;
                          ((amkl.a)localObject3).ajO = amkl.a((amrd)localObject1);
                          ((amkl.a)localObject3).key = ((amrd)localObject1).cbY;
                          amkl.mT.put((amrd)localObject1, localObject3);
                        }
                      }
                      if ((!(localObject1 instanceof ampw)) || (((ampw)localObject1).eX() == null)) {
                        break label3138;
                      }
                      localObject3 = ((ampw)localObject1).eX().iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        localObject4 = (ampx)((Iterator)localObject3).next();
                        if ((localObject4 instanceof ampy)) {
                          ((ampy)localObject4).setSource(GroupSearchFragment.b(this.this$0));
                        }
                      }
                      i = 2;
                      break label2335;
                      label2881:
                      if (this.this$0.dCV != 0) {
                        break label2465;
                      }
                      this.this$0.dCV = 4;
                      break label2465;
                      label2902:
                      i = 3;
                      break label2483;
                      label2907:
                      i = 11;
                      break label2498;
                      this.this$0.mHandler.removeMessages(i);
                      this.this$0.mHandler.sendEmptyMessageDelayed(i, 50L - (l - this.this$0.lastUpdateTime));
                      break label2543;
                      break;
                      if ((localObject1 instanceof ampw))
                      {
                        localObject3 = (ampw)localObject1;
                        localObject4 = ((ampw)localObject3).eX();
                        k = i;
                        m = j;
                        if (localObject4 != null)
                        {
                          m = Math.min(((List)localObject4).size(), ((ampw)localObject3).Ex());
                          k = 0;
                          while (k < Math.min(((List)localObject4).size(), ((ampw)localObject3).Ex()))
                          {
                            localObject5 = new amkl.a();
                            i += 1;
                            ((amkl.a)localObject5).index = i;
                            ((amkl.a)localObject5).ajO = amkl.a((ampw)localObject1);
                            ((amkl.a)localObject5).key = ((ampw)localObject1).getKeyword();
                            amkl.mT.put(((List)localObject4).get(k), localObject5);
                            k += 1;
                          }
                          m = j + m;
                          k = i;
                        }
                        i = m;
                        j = k;
                      }
                      else
                      {
                        k = j + 1;
                        j = i;
                        i = k;
                      }
                    }
                    label3138:
                    if ((localObject1 != null) && ((localObject1 instanceof amph)) && (((amph)localObject1).eX() != null) && (((amph)localObject1).eX().size() > 0))
                    {
                      j = 1;
                      label3180:
                      if (j != 0)
                      {
                        localObject3 = (ampx)((amph)localObject1).eX().get(0);
                        if ((((localObject3 instanceof amow)) && (!TextUtils.isEmpty(((amow)localObject3).name))) && ((j == 0) || (!((amow)localObject3).name.equals(this.this$0.keyword)))) {}
                      }
                      if ((localObject1 == null) || (!(localObject1 instanceof ampm)) || (((ampm)localObject1).eX() == null) || (((ampm)localObject1).eX().size() <= 0)) {
                        break label3377;
                      }
                      j = 1;
                      label3292:
                      if (j != 0)
                      {
                        localObject1 = (ampx)((ampm)localObject1).eX().get(0);
                        if ((!(localObject1 instanceof amqc)) || (TextUtils.isEmpty(((amqc)localObject1).za()))) {
                          break label3382;
                        }
                      }
                    }
                    label3377:
                    label3382:
                    for (j = 1;; j = 0)
                    {
                      if ((j != 0) && (((amqc)localObject1).za().equals(this.this$0.keyword))) {}
                      j = i;
                      i = k;
                      break;
                      j = 0;
                      break label3180;
                      j = 0;
                      break label3292;
                    }
                    label3387:
                    i = j;
                    label3389:
                    paramMessage = new JSONObject();
                    try
                    {
                      paramMessage.put("project", amub.zn());
                      paramMessage.put("event_src", "client");
                      paramMessage.put("nav_num", i);
                      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                      amub.a((QQAppInterface)localObject1, new ReportModelDC02528().module("all_result").action("exp_items").ver1(this.this$0.keyword).ver2(amub.eZ(GroupSearchFragment.a(this.this$0))).ver7(paramMessage.toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + amkl.ajN));
                      amxk.b("all_result", "exp_all_result", new String[] { this.this$0.keyword });
                      return;
                    }
                    catch (JSONException localJSONException)
                    {
                      for (;;)
                      {
                        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
                      }
                    }
                    break label1286;
                    localObject5 = null;
                    localObject4 = null;
                    break label1170;
                    localObject3 = null;
                    localObject2 = null;
                    break label1095;
                    i = 10;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ammz
 * JD-Core Version:    0.7.0.1
 */