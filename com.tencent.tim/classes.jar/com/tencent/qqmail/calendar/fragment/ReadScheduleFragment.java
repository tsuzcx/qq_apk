package com.tencent.qqmail.calendar.fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSONObject;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.qqmail.calendar.data.CreditCardBill;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.calendar.util.QMLunarCalendarUtils;
import com.tencent.qqmail.calendar.view.DrawBitmapUtil;
import com.tencent.qqmail.calendar.view.ScheduleTimeReadView;
import com.tencent.qqmail.calendar.watcher.ScheduleUpdateWatcher;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.qmui.helper.QMUIDisplayHelper;
import com.tencent.qqmail.qmui.helper.QMUIViewHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.UITableContainer;
import com.tencent.qqmail.utilities.uitableview.UITableItemFactory;
import com.tencent.qqmail.utilities.uitableview.UITableItemMultiView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class ReadScheduleFragment
  extends CalendarBaseFragment
{
  private static final String TAG = "ReadScheduleFragment";
  private final int REQUEST_MODIFY = 1;
  private View acceptBtn;
  private TextView acceptBtnText;
  private View.OnClickListener attendeeListener = new ReadScheduleFragment.13(this);
  private View btnGroupLayout;
  private CreditCardBill creditCardBill;
  private View creditCardBillDetailViewGroup;
  private UITableItemMultiView creditCardBillinfoItemView;
  private View declineBtn;
  private TextView declineBtnText;
  private TextView deleteEventItemView;
  private View.OnClickListener eventDeleteListener = new ReadScheduleFragment.17(this);
  private View.OnClickListener eventOperationListener = new ReadScheduleFragment.16(this);
  private View.OnClickListener eventShareListener = new ReadScheduleFragment.22(this);
  private boolean fromNotification = false;
  private View infoAttendeesContainerView;
  private TextView infoAttendeesTextView;
  private View infoBelongToContainerView;
  private TextView infoBelongToTextView;
  private UITableItemMultiView infoItemView;
  private View infoLocationContainerView;
  private TextView infoLocationTextView;
  private View infoRemarkArrowView;
  private View infoRemarkContainerView;
  private TextView infoRemarkTextView;
  private TextView infoRemindTextView;
  private TextView infoRepeatTextView;
  private View infoShareSourceContainerView;
  private TextView infoShareSourceTextView;
  private TextView infoSubjectTextView;
  private UITableContainer infoTableContainer;
  private ScheduleTimeReadView infoTimeItemView;
  private Future<Boolean> isDoneReadingEvent = null;
  private ScrollView mReadEventRootScrollView;
  private QMBaseView mReadEventView;
  private QMSchedule mSchedule;
  private QMCalendarEvent mSpecificEvent;
  private QMTopBar mTopBar;
  private View.OnClickListener onBodyClickListener = new ReadScheduleFragment.14(this);
  private View.OnClickListener onRelativeClickListener = new ReadScheduleFragment.15(this);
  private TextView relativeItemView;
  private ScheduleUpdateWatcher scheduleUpdateWatcher = new ReadScheduleFragment.1(this);
  private TextView shareItemView;
  private View tentativeBtn;
  private TextView tentativeBtnText;
  
  public ReadScheduleFragment()
  {
    super(false);
  }
  
  public ReadScheduleFragment(CreditCardBill paramCreditCardBill)
  {
    this();
    this.creditCardBill = paramCreditCardBill;
    this.fromNotification = true;
  }
  
  private void checkScheduleTypeBeforeShowView()
  {
    if ((this.fromNotification) && (this.creditCardBill != null)) {
      toggleToCreditCardMode(true);
    }
    while ((this.mSchedule == null) || (this.mSpecificEvent == null)) {
      return;
    }
    if (!this.mSchedule.getSubject().endsWith(getString(2131718764)))
    {
      toggleToCreditCardMode(false);
      return;
    }
    String str = this.mSpecificEvent.getCreateTime() + "" + this.mSpecificEvent.getAccountId() + this.mSpecificEvent.getId() + "";
    JSONObject localJSONObject = (JSONObject)JSONObject.parse(SharedPreferenceUtil.getCreditCardBillDetail(str));
    if (localJSONObject != null)
    {
      this.creditCardBill = CreditCardBill.parse(localJSONObject);
      Log.i("ReadScheduleFragment", "local creditCardBill " + this.creditCardBill + " thread " + Thread.currentThread());
      if (this.creditCardBill == null)
      {
        toggleToCreditCardMode(false);
        return;
      }
      toggleToCreditCardMode(true);
      return;
    }
    if (SharedPreferenceUtil.getNormalCreditCardBill(str))
    {
      toggleToCreditCardMode(false);
      return;
    }
    QMMailManager.sharedInstance().getMailReminderCreditDetail(this.mSpecificEvent.getAccountId(), this.mSpecificEvent.getSvrId(), new ReadScheduleFragment.3(this, str));
  }
  
  private void deleteCreditCardBillReminderDialog()
  {
    Object localObject = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718766), getString(2131718766));
    ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718765), getString(2131718765));
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setOnSheetItemClickListener(new ReadScheduleFragment.8(this));
    localObject = ((QMBottomDialog.BottomListSheetBuilder)localObject).build();
    ((QMBottomDialog)localObject).setOnDismissListener(new ReadScheduleFragment.9(this));
    ((QMBottomDialog)localObject).show();
  }
  
  private void deleteEvent(QMCalendarEvent paramQMCalendarEvent, int paramInt, QMSchedule paramQMSchedule)
  {
    Threads.runInBackground(new ReadScheduleFragment.21(this, paramQMCalendarEvent, paramInt, paramQMSchedule));
  }
  
  private String generateScheme(String paramString, HashMap<String, List<String>> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://mail.qq.com/cgi-bin/").append(paramString).append("?");
    paramString = paramHashMap.entrySet().iterator();
    while (paramString.hasNext())
    {
      paramHashMap = (Map.Entry)paramString.next();
      Object localObject = (List)paramHashMap.getValue();
      paramHashMap = (String)paramHashMap.getKey();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localStringBuilder.append(paramHashMap).append("=").append(str);
        localStringBuilder.append("&");
      }
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  private void inflateCreditCardBillDetail()
  {
    if (this.creditCardBill == null) {
      return;
    }
    this.mTopBar.setTitle(2131718764);
    this.mTopBar.getButtonRight().setVisibility(8);
    ImageView localImageView = (ImageView)this.creditCardBillDetailViewGroup.findViewById(2131363276);
    Object localObject1 = (TextView)this.creditCardBillDetailViewGroup.findViewById(2131372912);
    Object localObject2 = (TextView)this.creditCardBillDetailViewGroup.findViewById(2131372927);
    Object localObject3 = (TextView)this.creditCardBillDetailViewGroup.findViewById(2131372919);
    Object localObject4 = (TextView)this.creditCardBillDetailViewGroup.findViewById(2131363278);
    Object localObject5 = (TextView)this.creditCardBillDetailViewGroup.findViewById(2131372776);
    TextView localTextView = (TextView)this.creditCardBillDetailViewGroup.findViewById(2131372567);
    if (QMUIViewHelper.getIsLastLineSpacingExtraError())
    {
      i = getResources().getDimensionPixelSize(2131299337);
      ((LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams()).bottomMargin = (-i);
      ((LinearLayout.LayoutParams)((TextView)localObject2).getLayoutParams()).bottomMargin = (-i);
      ((LinearLayout.LayoutParams)((TextView)localObject3).getLayoutParams()).bottomMargin = (-i);
    }
    ((TextView)localObject5).setText(this.creditCardBill.owner);
    ((TextView)localObject4).setText(this.creditCardBill.bank);
    localTextView.setText(this.creditCardBill.num.substring(this.creditCardBill.num.length() - 4));
    ((TextView)localObject3).setText(this.creditCardBill.date);
    localObject3 = Pattern.compile("\\(.*\\)");
    int i = ContextCompat.getColor(getActivity(), 2131166576);
    localObject5 = this.creditCardBill.minPayAmount;
    localObject4 = new SpannableString((CharSequence)localObject5);
    localObject5 = ((Pattern)localObject3).matcher((CharSequence)localObject5);
    while (((Matcher)localObject5).find()) {
      ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(i), ((Matcher)localObject5).start(), ((Matcher)localObject5).end(), 18);
    }
    ((TextView)localObject2).setText((CharSequence)localObject4);
    localObject5 = this.creditCardBill.allPayAmount;
    localObject4 = new SpannableString((CharSequence)localObject5);
    localObject3 = ((Pattern)localObject3).matcher((CharSequence)localObject5);
    while (((Matcher)localObject3).find()) {
      ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(i), ((Matcher)localObject3).start(), ((Matcher)localObject3).end(), 18);
    }
    ((TextView)localObject1).setText((CharSequence)localObject4);
    if (this.creditCardBill.mutiCurrencyBill)
    {
      localObject3 = new TextView(getActivity());
      ((TextView)localObject3).setText(2131718770);
      ((TextView)localObject3).setTextColor(i);
      ((TextView)localObject3).setPadding(QMUIKit.dpToPx(16), QMUIKit.dpToPx(-5), 0, QMUIKit.dpToPx(4));
      ((TextView)localObject3).setTextSize(14.0F);
      this.mReadEventView.addContentView((View)localObject3);
      localObject3 = this.creditCardBillDetailViewGroup.findViewById(2131377693);
      ((View)localObject3).setPadding(((View)localObject3).getPaddingLeft(), ((View)localObject3).getPaddingTop(), ((View)localObject3).getPaddingTop(), QMUIDisplayHelper.dp2px(getActivity(), 23));
      i = QMUIDisplayHelper.dp2px(getActivity(), 4);
      ((TextView)localObject1).setPadding(0, 0, 0, i);
      ((TextView)localObject2).setPadding(0, 0, 0, i);
    }
    localObject1 = UITableItemFactory.addCenterTextView(getActivity());
    ((TextView)localObject1).setText(2131696740);
    ((TextView)localObject1).setOnClickListener(new ReadScheduleFragment.4(this));
    this.mReadEventView.addContentView((View)localObject1);
    if (TextUtils.isEmpty(this.creditCardBill.owner)) {
      this.creditCardBillDetailViewGroup.findViewById(2131372777).setVisibility(8);
    }
    localObject1 = UITableItemFactory.addCenterTextView(getActivity());
    ((TextView)localObject1).setText(2131691556);
    ((TextView)localObject1).setTextColor(ActivityCompat.getColor(getActivity(), 2131167180));
    ((TextView)localObject1).setOnClickListener(new ReadScheduleFragment.5(this));
    this.mReadEventView.addContentView((View)localObject1);
    localObject1 = QMPrivateProtocolManager.getPhotoBitmapByEmail(this.creditCardBill.from, 3);
    if (localObject1 != null)
    {
      localImageView.setImageBitmap((Bitmap)localObject1);
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(this.creditCardBill.from);
    localObject2 = new QMCallback();
    ((QMCallback)localObject2).setOnSuccess(new ReadScheduleFragment.6(this, localImageView));
    ((QMCallback)localObject2).setOnError(new ReadScheduleFragment.7(this));
    QMPrivateProtocolManager.sharedInstance().syncEmailIconByRedirect((List)localObject1, (QMCallback)localObject2);
  }
  
  private HashMap<String, List<String>> initUriData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("check", Arrays.asList(new String[] { "false" }));
    localHashMap.put("t", Arrays.asList(new String[] { "qm_wecal_eventDetail" }));
    String str1;
    long l2;
    long l1;
    label176:
    String str2;
    if (StringUtils.isBlank(this.mSpecificEvent.getSubject()))
    {
      str1 = "";
      localHashMap.put("subject", Arrays.asList(new String[] { str1 }));
      boolean bool = this.mSpecificEvent.isAllDay();
      long l3 = this.mSpecificEvent.getStartTime();
      l2 = this.mSpecificEvent.getEndTime();
      if (!bool) {
        break label740;
      }
      l1 = l2;
      if ((l2 - l3) / 86400000L < (1000L + l2 - l3) / 86400000L) {
        l1 = l2 + 1000L;
      }
      str1 = QMCalendarUtil.getStringByAllDayReminder(this.mSpecificEvent.getReminder(), this.mSpecificEvent.getStartTime());
      if (!bool) {
        break label765;
      }
      str2 = "1";
      label185:
      localHashMap.put("allday", Arrays.asList(new String[] { str2 }));
      localHashMap.put("s_t", Arrays.asList(new String[] { String.valueOf(l3 / 1000L) }));
      localHashMap.put("e_t", Arrays.asList(new String[] { String.valueOf(l1 / 1000L) }));
      localHashMap.put("alarm_t", Arrays.asList(new String[] { String.valueOf(this.mSpecificEvent.getReminder()) }));
      if (!StringUtils.isBlank(str1)) {
        break label773;
      }
      str1 = "";
      label302:
      localHashMap.put("alarm_desc", Arrays.asList(new String[] { str1 }));
      if (!StringUtils.isBlank(this.mSpecificEvent.getLocation())) {
        break label783;
      }
      str1 = "";
      label340:
      localHashMap.put("location", Arrays.asList(new String[] { str1 }));
      localHashMap.put("recur_desc", Arrays.asList(new String[] { String.valueOf(this.mSpecificEvent.getRecurrenceType()) }));
      localHashMap.put("r_dayOfWeek", Arrays.asList(new String[] { String.valueOf(this.mSpecificEvent.getDayOfWeek()) }));
      localHashMap.put("r_dayOfMonth", Arrays.asList(new String[] { String.valueOf(this.mSpecificEvent.getDayOfMonth()) }));
      localHashMap.put("r_weekOfMonth", Arrays.asList(new String[] { String.valueOf(this.mSpecificEvent.getWeekOfMonth()) }));
      localHashMap.put("r_monthOfYear", Arrays.asList(new String[] { String.valueOf(this.mSpecificEvent.getMonthOfYear()) }));
      if (!StringUtils.isBlank(this.mSpecificEvent.getBody())) {
        break label801;
      }
      str1 = "";
      label523:
      localHashMap.put("notes", Arrays.asList(new String[] { str1 }));
      if (!this.mSpecificEvent.isLunarCalendar()) {
        break label819;
      }
    }
    label773:
    label783:
    label801:
    label819:
    for (int i = 15;; i = 0)
    {
      localHashMap.put("r_calendarType", Arrays.asList(new String[] { String.valueOf(i) }));
      localHashMap.put("recurrence", Arrays.asList(new String[] { Uri.encode(QMCalendarUtil.createReadableStringOfRecurrence(this.mSpecificEvent)) }));
      localHashMap.put("lunarStartDateString", Arrays.asList(new String[] { Uri.encode(QMLunarCalendarUtils.getLunarDate(this.mSpecificEvent.getStartTime(), true)) }));
      localHashMap.put("lunarEndDateString", Arrays.asList(new String[] { Uri.encode(QMLunarCalendarUtils.getLunarDate(this.mSpecificEvent.getEndTime(), true)) }));
      localHashMap.put("resp_charset", Arrays.asList(new String[] { "UTF8" }));
      localHashMap.put("os", Arrays.asList(new String[] { "android" }));
      return localHashMap;
      str1 = Uri.encode(Uri.encode(this.mSpecificEvent.getSubject()));
      break;
      label740:
      str1 = QMCalendarUtil.getStringByReminder(this.mSpecificEvent.getReminder(), this.mSpecificEvent.getStartTime());
      l1 = l2;
      break label176;
      label765:
      str2 = "0";
      break label185;
      str1 = Uri.encode(str1);
      break label302;
      str1 = Uri.encode(Uri.encode(this.mSpecificEvent.getLocation()));
      break label340;
      str1 = Uri.encode(Uri.encode(this.mSpecificEvent.getBody()));
      break label523;
    }
  }
  
  private void renderResponseButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      setButtonBarVisibility(8);
      return;
    case 3: 
      this.acceptBtn.setBackgroundResource(2130839031);
      this.acceptBtnText.setTextColor(getResources().getColor(2131167654));
      this.acceptBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840930), null, null, null);
      this.tentativeBtn.setBackgroundResource(2130851774);
      this.tentativeBtnText.setTextColor(getResources().getColor(2131167170));
      this.tentativeBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840933), null, null, null);
      this.declineBtn.setBackgroundResource(2130851774);
      this.declineBtnText.setTextColor(getResources().getColor(2131167173));
      this.declineBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840931), null, null, null);
      this.acceptBtn.setClickable(false);
      this.tentativeBtn.setClickable(true);
      this.declineBtn.setClickable(true);
      setButtonBarVisibility(0);
      return;
    case 2: 
      this.acceptBtn.setBackgroundResource(2130851774);
      this.acceptBtnText.setTextColor(getResources().getColor(2131167171));
      this.acceptBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840929), null, null, null);
      this.tentativeBtn.setBackgroundResource(2130839030);
      this.tentativeBtnText.setTextColor(getResources().getColor(2131167654));
      this.tentativeBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840934), null, null, null);
      this.declineBtn.setBackgroundResource(2130851774);
      this.declineBtnText.setTextColor(getResources().getColor(2131167173));
      this.declineBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840931), null, null, null);
      this.acceptBtn.setClickable(true);
      this.tentativeBtn.setClickable(false);
      this.declineBtn.setClickable(true);
      setButtonBarVisibility(0);
      return;
    case 4: 
      this.acceptBtn.setBackgroundResource(2130851774);
      this.acceptBtnText.setTextColor(getResources().getColor(2131167171));
      this.acceptBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840929), null, null, null);
      this.tentativeBtn.setBackgroundResource(2130851774);
      this.tentativeBtnText.setTextColor(getResources().getColor(2131167170));
      this.tentativeBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840933), null, null, null);
      this.declineBtn.setBackgroundResource(2130839033);
      this.declineBtnText.setTextColor(getResources().getColor(2131167654));
      this.declineBtnText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840932), null, null, null);
      this.acceptBtn.setClickable(true);
      this.tentativeBtn.setClickable(true);
      this.declineBtn.setClickable(false);
      setButtonBarVisibility(0);
      return;
    }
    setButtonBarVisibility(0);
  }
  
  private void setButtonBarVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (int i = getResources().getDimensionPixelSize(2131299250);; i = 0)
    {
      this.btnGroupLayout.setVisibility(paramInt);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mReadEventRootScrollView.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, i);
      this.mReadEventRootScrollView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  private void shareToWX(int paramInt)
  {
    if (WXEntryActivity.canShareToWX(getActivity()))
    {
      QMCalendarManager.logEvent("Event_Calendar_Share_Event");
      Object localObject = new WXWebpageObject();
      ((WXWebpageObject)localObject).webpageUrl = generateScheme("readtemplate", initUriData());
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.mSpecificEvent.getStartTime());
      localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
      ((WXMediaMessage)localObject).title = this.mSpecificEvent.getSubject();
      ((WXMediaMessage)localObject).description = (QMCalendarUtil.getDayString(localCalendar) + QMCalendarUtil.getTimeString(localCalendar));
      ((WXMediaMessage)localObject).thumbData = WXEntryActivity.bmpToByteArray(BitmapFactory.decodeResource(getResources(), 2130850725), false);
      WXEntryActivity.shareWebpage(getActivity(), paramInt, (WXMediaMessage)localObject, 3);
    }
  }
  
  private void showDeleteTipsDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131691070)).setMessage(2131691071).addAction(2131691246, new ReadScheduleFragment.19(this))).addAction(0, 2131692498, 2, new ReadScheduleFragment.18(this))).create().show();
  }
  
  private void showModifyChoseDialog()
  {
    Object localObject = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setTitle(2131691104);
    if (this.mSpecificEvent.getAccountId() == 0)
    {
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691105));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691106));
    }
    for (;;)
    {
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setOnSheetItemClickListener(new ReadScheduleFragment.20(this));
      localObject = ((QMBottomDialog.BottomListSheetBuilder)localObject).build();
      ((QMBottomDialog)localObject).setCanceledOnTouchOutside(true);
      ((QMBottomDialog)localObject).show();
      return;
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691107));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691106));
    }
  }
  
  private void toggleToCreditCardMode(boolean paramBoolean)
  {
    QMLog.log(4, "ReadScheduleFragment", "toggleToCreditCardMode " + paramBoolean);
    if (paramBoolean)
    {
      this.infoTableContainer.addItem(this.creditCardBillinfoItemView);
      this.shareItemView.setVisibility(8);
      this.deleteEventItemView.setVisibility(8);
      this.relativeItemView.setVisibility(8);
      inflateCreditCardBillDetail();
      return;
    }
    this.infoTableContainer.addItem(this.infoItemView);
    if ((this.mSpecificEvent != null) && (this.mSpecificEvent.getAppointmentType() == 0))
    {
      this.shareItemView.setVisibility(0);
      label109:
      if (this.mSpecificEvent == null) {
        break label206;
      }
      QMCalendarFolder localQMCalendarFolder = QMCalendarManager.getInstance().getCalendarFolder(this.mSpecificEvent.getAccountId(), this.mSpecificEvent.getCalderFolderId());
      if ((localQMCalendarFolder == null) || (localQMCalendarFolder.isSelfFolder())) {
        break label208;
      }
      this.deleteEventItemView.setVisibility(8);
    }
    int i;
    for (;;)
    {
      i = this.mSpecificEvent.getRelateType();
      if (this.creditCardBill != null) {
        break;
      }
      if (i != 1) {
        break label288;
      }
      this.relativeItemView.setVisibility(0);
      this.relativeItemView.setText(2131691203);
      return;
      this.shareItemView.setVisibility(8);
      break label109;
      label206:
      break;
      label208:
      if ((this.mSpecificEvent.getAppointmentType() == 0) || (this.mSpecificEvent.getMeetingStatus() == 5) || (this.mSpecificEvent.getMeetingStatus() == 7) || (this.mSpecificEvent.getMeetingStatus() == 13) || (this.mSpecificEvent.getMeetingStatus() == 15)) {
        this.deleteEventItemView.setVisibility(0);
      } else {
        this.deleteEventItemView.setVisibility(8);
      }
    }
    label288:
    if ((i == 2) && (QMSettingManager.sharedInstance().getNoteDisplay()) && (this.mSpecificEvent.getRelateAccountId() == QMSettingManager.sharedInstance().getDefaultNoteAccountID()))
    {
      this.relativeItemView.setVisibility(0);
      this.relativeItemView.setText(2131691204);
      return;
    }
    this.relativeItemView.setVisibility(8);
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.mReadEventView.getScrollBodyView().setPadding(0, 0, 0, this.mReadEventView.getScrollBodyView().getPaddingBottom());
    this.infoTableContainer = new UITableContainer(getActivity());
    this.infoTableContainer.setBackgroundColor(getResources().getColor(2131167681));
    this.mReadEventView.addContentView(this.infoTableContainer);
    paramView = (LinearLayout.LayoutParams)this.infoTableContainer.getLayoutParams();
    paramView.setMargins(paramView.leftMargin, QMUIKit.dpToPx(-1), paramView.rightMargin, paramView.bottomMargin);
    this.infoTableContainer.setLayoutParams(paramView);
    this.infoItemView = new UITableItemMultiView(getActivity());
    this.infoItemView.setCustomerPaddingLeft(0);
    this.infoItemView.setCustomerPaddingRight(0);
    paramView = this.infoItemView.setLayoutFromXml(2131558807);
    this.infoSubjectTextView = ((TextView)paramView.findViewById(2131369250));
    this.infoLocationContainerView = paramView.findViewById(2131369238);
    this.infoLocationTextView = ((TextView)paramView.findViewById(2131369237));
    this.infoTimeItemView = ((ScheduleTimeReadView)paramView.findViewById(2131369252));
    this.infoRepeatTextView = ((TextView)paramView.findViewById(2131369246));
    this.infoRemindTextView = ((TextView)paramView.findViewById(2131369245));
    this.infoBelongToContainerView = paramView.findViewById(2131369160);
    this.infoBelongToTextView = ((TextView)paramView.findViewById(2131369159));
    this.infoShareSourceContainerView = paramView.findViewById(2131369248);
    this.infoShareSourceTextView = ((TextView)paramView.findViewById(2131369247));
    this.infoAttendeesContainerView = paramView.findViewById(2131369158);
    this.infoAttendeesContainerView.setOnClickListener(this.attendeeListener);
    this.infoAttendeesTextView = ((TextView)paramView.findViewById(2131369157));
    this.infoRemarkContainerView = paramView.findViewById(2131369244);
    this.infoRemarkArrowView = paramView.findViewById(2131369243);
    this.infoRemarkTextView = ((TextView)paramView.findViewById(2131369242));
    this.infoRemarkTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ReadScheduleFragment.2(this));
    this.relativeItemView = UITableItemFactory.addCenterTextView(getActivity());
    this.relativeItemView.setText(2131691203);
    this.relativeItemView.setOnClickListener(this.onRelativeClickListener);
    this.mReadEventView.addContentView(this.relativeItemView);
    this.shareItemView = UITableItemFactory.addCenterTextView(getActivity());
    this.shareItemView.setText(2131691205);
    this.shareItemView.setOnClickListener(this.eventShareListener);
    this.mReadEventView.addContentView(this.shareItemView);
    this.deleteEventItemView = UITableItemFactory.addCenterTextView(getActivity(), 2130850545);
    this.deleteEventItemView.setText(2131691070);
    this.deleteEventItemView.setTextColor(getResources().getColorStateList(2131167539));
    this.deleteEventItemView.setOnClickListener(this.eventDeleteListener);
    this.mReadEventView.addContentView(this.deleteEventItemView);
    this.btnGroupLayout = LayoutInflater.from(getActivity()).inflate(2131562906, null);
    this.acceptBtn = this.btnGroupLayout.findViewById(2131376650);
    this.tentativeBtn = this.btnGroupLayout.findViewById(2131376654);
    this.declineBtn = this.btnGroupLayout.findViewById(2131376652);
    this.acceptBtnText = ((TextView)this.acceptBtn.findViewById(2131376651));
    this.tentativeBtnText = ((TextView)this.tentativeBtn.findViewById(2131376655));
    this.declineBtnText = ((TextView)this.declineBtn.findViewById(2131376653));
    this.acceptBtn.setOnClickListener(this.eventOperationListener);
    this.tentativeBtn.setOnClickListener(this.eventOperationListener);
    this.declineBtn.setOnClickListener(this.eventOperationListener);
    paramView = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299250), 80);
    this.btnGroupLayout.setLayoutParams(paramView);
    this.mReadEventView.addView(this.btnGroupLayout);
    this.mReadEventRootScrollView = this.mReadEventView.getRootScrollView();
    setButtonBarVisibility(0);
    this.creditCardBillinfoItemView = new UITableItemMultiView(getActivity());
    this.creditCardBillinfoItemView.setCustomerPaddingLeft(0);
    this.creditCardBillinfoItemView.setCustomerPaddingRight(0);
    this.creditCardBillDetailViewGroup = this.creditCardBillinfoItemView.setLayoutFromXml(2131558806);
    this.shareItemView.setVisibility(8);
    this.deleteEventItemView.setVisibility(8);
    this.relativeItemView.setVisibility(8);
    checkScheduleTypeBeforeShowView();
  }
  
  public void initTopbar(View paramView)
  {
    this.mTopBar = new QMTopBar(getActivity());
    this.mReadEventView.addView(this.mTopBar);
    this.mTopBar.setTitle(getResources().getString(2131691101));
    this.mTopBar.setButtonLeftBack();
    this.mTopBar.setButtonRightIcon(2130841091);
    this.mTopBar.setButtonLeftOnclickListener(new ReadScheduleFragment.10(this));
    this.mTopBar.setButtonRightOnclickListener(new ReadScheduleFragment.11(this));
    this.mTopBar.getButtonRight().setContentDescription(getString(2131720836));
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mReadEventView = new QMBaseView(getActivity());
    this.mReadEventView.initScrollView();
    this.mReadEventView.getRootScrollView().setBackgroundColor(getResources().getColor(2131167681));
    return this.mReadEventView;
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    QMCalendarManager.getInstance().bindLoadEventListWatcher(this.scheduleUpdateWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      this.mSpecificEvent.set((QMCalendarEvent)paramHashMap.get("event"));
    }
  }
  
  public Object onLastFragmentFinish()
  {
    return new CalendarMainFragment();
  }
  
  public void onRelease()
  {
    this.infoAttendeesContainerView.setOnClickListener(null);
    this.relativeItemView.setOnClickListener(null);
    this.infoRemarkContainerView.setOnClickListener(null);
  }
  
  public void prepareEvent(QMSchedule paramQMSchedule)
  {
    if (this.isDoneReadingEvent != null) {
      this.isDoneReadingEvent.cancel(true);
    }
    setSchedule(paramQMSchedule);
    this.isDoneReadingEvent = Threads.submitTask(new ReadScheduleFragment.12(this));
  }
  
  public int refreshData()
  {
    if (this.fromNotification) {}
    for (;;)
    {
      return 0;
      if (this.isDoneReadingEvent != null) {}
      try
      {
        this.isDoneReadingEvent.get();
        this.isDoneReadingEvent = null;
        if (this.mSpecificEvent == null) {
          this.mSpecificEvent = QMCalendarManager.getInstance().getDetailCalendarEventFromSchedule(this.mSchedule);
        }
        if ((this.mSpecificEvent != null) && (this.mSchedule != null)) {
          continue;
        }
        finish();
        return 0;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
      catch (ExecutionException localExecutionException)
      {
        for (;;)
        {
          localExecutionException.printStackTrace();
        }
      }
    }
  }
  
  public void refreshTopbar()
  {
    int j = 1;
    int i = j;
    Object localObject;
    if (this.mSpecificEvent != null)
    {
      localObject = QMCalendarManager.getInstance().getCalendarFolder(this.mSpecificEvent.getAccountId(), this.mSpecificEvent.getCalderFolderId());
      i = j;
      if (localObject != null) {
        if ((!((QMCalendarFolder)localObject).isEditable()) || (!((QMCalendarFolder)localObject).isSelfFolder())) {
          break label84;
        }
      }
    }
    label84:
    for (i = j;; i = 0)
    {
      if (this.mTopBar != null)
      {
        localObject = this.mTopBar.getButtonRight();
        if ((localObject != null) && (i == 0)) {
          ((View)localObject).setVisibility(8);
        }
      }
      return;
    }
  }
  
  public void render(int paramInt)
  {
    refreshTopbar();
    if ((this.fromNotification) || (this.mSpecificEvent == null))
    {
      setButtonBarVisibility(8);
      return;
    }
    if (!StringUtils.isBlank(this.mSpecificEvent.getSubject()))
    {
      this.infoSubjectTextView.setVisibility(0);
      this.infoSubjectTextView.setText(this.mSpecificEvent.getSubject());
      if (StringUtils.isBlank(this.mSpecificEvent.getLocation())) {
        break label498;
      }
      this.infoLocationContainerView.setVisibility(0);
      this.infoLocationTextView.setText(this.mSpecificEvent.getLocation());
      label95:
      this.infoTimeItemView.setTime(this.mSpecificEvent.getStartTime(), this.mSpecificEvent.getEndTime(), this.mSpecificEvent.isAllDay(), this.mSpecificEvent.isLunarCalendar());
      if (!this.mSpecificEvent.isAllDay()) {
        break label510;
      }
      this.infoRemindTextView.setText(QMCalendarUtil.getStringByAllDayReminder(this.mSpecificEvent.getReminder(), this.mSpecificEvent.getStartTime()));
      label164:
      if ((this.mSpecificEvent.getRecurrenceType() == -1) || ((this.mSchedule != null) && (!StringUtils.isBlank(this.mSchedule.getExceptionId())))) {
        break label537;
      }
      this.infoRepeatTextView.setText(QMCalendarUtil.createReadableStringOfRecurrence(this.mSpecificEvent));
      ((ViewGroup)this.infoRepeatTextView.getParent()).setVisibility(0);
      label223:
      if ((this.mSpecificEvent.getAttendees() == null) || (this.mSpecificEvent.getAttendees().size() <= 0)) {
        break label555;
      }
      this.infoAttendeesContainerView.setVisibility(0);
      this.infoAttendeesTextView.setText(this.mSpecificEvent.getAttendees().size() + 1 + "");
      label291:
      Object localObject = QMCalendarManager.getInstance().getCalendarFolder(this.mSpecificEvent.getAccountId(), this.mSpecificEvent.getCalderFolderId());
      if (localObject == null) {
        break label567;
      }
      Drawable localDrawable = DrawBitmapUtil.drawCircle(getActivity(), QMUIHelper.getCalendarColor(getActivity(), (QMCalendarFolder)localObject), DrawBitmapUtil.CIRCLE_DIAMETER_NORMAL, Paint.Style.STROKE);
      this.infoBelongToContainerView.setVisibility(0);
      this.infoBelongToTextView.setText(((QMCalendarFolder)localObject).getName());
      this.infoBelongToTextView.setCompoundDrawables(localDrawable, null, null, null);
      label368:
      if ((localObject == null) || (!((QMCalendarFolder)localObject).isShareReceiverFolder())) {
        break label579;
      }
      this.infoShareSourceContainerView.setVisibility(0);
      this.infoShareSourceTextView.setText(((QMCalendarFolder)localObject).getShareOwner());
      label398:
      localObject = QMCalendarUtil.getValidateBodyText(this.mSpecificEvent.getBody());
      if (StringUtils.isBlank((CharSequence)localObject)) {
        break label591;
      }
      this.infoRemarkContainerView.setVisibility(0);
      this.infoRemarkTextView.setText((CharSequence)localObject);
    }
    for (;;)
    {
      if ((this.mSpecificEvent.getMeetingStatus() != 5) && (this.mSpecificEvent.getMeetingStatus() != 7) && (this.mSpecificEvent.getMeetingStatus() != 13) && (this.mSpecificEvent.getMeetingStatus() != 15)) {
        break label603;
      }
      setButtonBarVisibility(8);
      return;
      this.infoSubjectTextView.setVisibility(8);
      break;
      label498:
      this.infoLocationContainerView.setVisibility(8);
      break label95;
      label510:
      this.infoRemindTextView.setText(QMCalendarUtil.getStringByReminder(this.mSpecificEvent.getReminder(), this.mSpecificEvent.getStartTime()));
      break label164;
      label537:
      ((ViewGroup)this.infoRepeatTextView.getParent()).setVisibility(8);
      break label223;
      label555:
      this.infoAttendeesContainerView.setVisibility(8);
      break label291;
      label567:
      this.infoBelongToContainerView.setVisibility(8);
      break label368;
      label579:
      this.infoShareSourceContainerView.setVisibility(8);
      break label398;
      label591:
      this.infoRemarkContainerView.setVisibility(8);
    }
    label603:
    renderResponseButton(this.mSpecificEvent.getAppointmentType());
  }
  
  public void setSchedule(QMSchedule paramQMSchedule)
  {
    this.mSchedule = paramQMSchedule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment
 * JD-Core Version:    0.7.0.1
 */