import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NeighborComm.RespHeader;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyPeopleListFrame;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class aww
  extends LBSObserver
{
  public aww(NearbyPeopleListFrame paramNearbyPeopleListFrame) {}
  
  protected void a(boolean paramBoolean, RespHeader paramRespHeader, RespGetEncounterV2 paramRespGetEncounterV2, ToServiceMsg paramToServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("gender");
    boolean bool = paramToServiceMsg.extraData.getBoolean("first");
    int j = paramToServiceMsg.extraData.getInt("classChild");
    long l = paramToServiceMsg.extraData.getLong("requestId");
    Object localObject = paramToServiceMsg.getUin();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdateGetEncounter isSuccess=").append(paramBoolean).append(" isFirst=").append(bool).append(" classChild=").append(j).append(" eReplyCode=");
      if (paramRespHeader == null) {
        break label191;
      }
    }
    label191:
    for (paramToServiceMsg = Integer.valueOf(paramRespHeader.eReplyCode);; paramToServiceMsg = "null")
    {
      QLog.d("NearbyPeopleListFrame", 2, paramToServiceMsg + " requestId=" + l + " mRequestId=" + this.a.b);
      NearbyPeopleListFrame.c(this.a);
      NearbyPeopleListFrame.a(this.a).setVisibility(8);
      if (l == this.a.b) {
        break;
      }
      return;
    }
    this.a.jdField_a_of_type_Boolean = false;
    if ((paramBoolean) && (paramRespGetEncounterV2 != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(true, true);
      this.a.m = paramRespGetEncounterV2.stUserData.iLat;
      this.a.n = paramRespGetEncounterV2.stUserData.iLon;
      if (i == this.a.b())
      {
        if (paramRespGetEncounterV2.stUserData.lNextGrid == -1L) {
          break label807;
        }
        NearbyPeopleListFrame.b(this.a).setVisibility(4);
        NearbyPeopleListFrame.c(this.a).setVisibility(0);
        paramRespHeader = paramRespGetEncounterV2.vEncounterInfos;
        if (bool)
        {
          this.a.jdField_a_of_type_JavaUtilList = new ArrayList(100);
          this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.a.jdField_a_of_type_JavaUtilList, true);
        }
        if (paramRespHeader != null) {
          this.a.jdField_a_of_type_JavaUtilList.addAll(paramRespHeader);
        }
        if ((!this.a.jdField_a_of_type_JavaUtilList.isEmpty()) && (bool) && (this.a.i != 4))
        {
          paramRespHeader = this.a.jdField_a_of_type_JavaUtilList;
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new awx(this, (String)localObject, paramRespHeader));
        }
        this.a.jdField_a_of_type_Long = System.currentTimeMillis();
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
        if (this.a.jdField_a_of_type_JavaUtilList.isEmpty())
        {
          paramRespHeader = this.a.a(2131298185);
          if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.a()) {
            break label832;
          }
          paramToServiceMsg = (TextView)paramRespHeader.findViewById(2131296422);
          paramToServiceMsg.setText(this.a.a(2131364451));
          paramToServiceMsg.setTextColor(NearbyPeopleListFrame.d(this.a).getResources().getColor(2131427498));
          paramRespHeader.findViewById(2131296424).setVisibility(4);
          paramRespHeader.setOnClickListener(null);
          this.a.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(paramRespHeader);
        }
        NearbyPeopleListFrame.a(this.a, false);
        if ((!StringUtil.b(paramRespGetEncounterV2.strSecurityTips)) && (!StringUtil.b(paramRespGetEncounterV2.strSecurityDetailUrl)))
        {
          paramRespHeader = DialogUtil.a(NearbyPeopleListFrame.f(this.a), 230);
          paramRespHeader.setTitle("温馨提示");
          paramRespHeader.getMessageTextView().setVisibility(8);
          paramToServiceMsg = paramRespHeader.getMessageTextView_Plain_Text();
          paramToServiceMsg.setVisibility(0);
          localObject = new SpannableString(paramRespGetEncounterV2.strSecurityTips + "了解更多");
          ((SpannableString)localObject).setSpan(new URLSpan(paramRespGetEncounterV2.strSecurityDetailUrl), paramRespGetEncounterV2.strSecurityTips.length(), ((SpannableString)localObject).length(), 18);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), paramRespGetEncounterV2.strSecurityTips.length(), ((SpannableString)localObject).length(), 33);
          paramToServiceMsg.setText((CharSequence)localObject);
          paramToServiceMsg.setMovementMethod(LinkMovementMethod.getInstance());
          paramRespHeader.setNegativeButton(2131362791, new awz(this, paramRespHeader));
          paramRespHeader.show();
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.a())) {
          break label898;
        }
        this.a.c = true;
        NearbyPeopleListFrame.a(this.a, 0, 1, true);
      }
    }
    label807:
    label832:
    while ((paramRespHeader == null) || (paramRespHeader.eReplyCode != 7)) {
      for (;;)
      {
        this.a.b(paramBoolean, bool);
        return;
        NearbyPeopleListFrame.b(this.a).setVisibility(0);
        NearbyPeopleListFrame.c(this.a).setVisibility(4);
        continue;
        paramToServiceMsg = (TextView)paramRespHeader.findViewById(2131296422);
        paramToServiceMsg.setText("当前筛选条件下找不到附近的人");
        paramToServiceMsg.setTextColor(NearbyPeopleListFrame.e(this.a).getResources().getColor(2131427471));
        paramRespHeader.findViewById(2131296424).setVisibility(0);
        paramRespHeader.setOnClickListener(new awy(this));
        continue;
        this.a.c = false;
        NearbyPeopleListFrame.b(this.a, 0, 1, false);
      }
    }
    label898:
    NearbyPeopleListFrame.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aww
 * JD-Core Version:    0.7.0.1
 */