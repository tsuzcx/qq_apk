import android.util.Pair;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

public class acqw
  extends tnx
{
  public Comparator w = new acqx(this);
  
  public acqw(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private ArrayList<MessageRecord> a(ArrayList<msg_comm.Msg> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      ajrk.m("HCTopicMsgProc", new Object[] { "<---groupMsgRecordHandle_PB", paramString, Integer.valueOf(paramArrayList.size()) });
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    anbl localanbl = new anbl();
    localanbl.friendUin = Long.valueOf(paramString).longValue();
    localanbl.uinType = 1026;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramString = (msg_comm.Msg)paramArrayList.next();
      if (paramString != null)
      {
        localArrayList1.clear();
        Object localObject = (msg_comm.MsgHead)paramString.msg_head.get();
        long l = ((msg_comm.MsgHead)localObject).msg_uid.get();
        localanbl.dEX = ((msg_comm.GroupInfo)((msg_comm.MsgHead)localObject).group_info.get()).group_type.get();
        try
        {
          a(paramString, localArrayList1, localanbl, false, null);
          if (localArrayList1.size() != 0)
          {
            achp.iZ(localArrayList1);
            if (localArrayList1.size() > 0)
            {
              paramString = localArrayList1.iterator();
              while (paramString.hasNext())
              {
                localObject = (MessageRecord)paramString.next();
                if (((MessageRecord)localObject).msgUid == 0L) {
                  ((MessageRecord)localObject).msgUid = l;
                }
              }
            }
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("HCTopicMsgProc", 2, "decodeSinglePbMsg_GroupDis error,", paramString);
            }
          }
          localArrayList2.addAll(localArrayList1);
        }
      }
    }
    jq(localArrayList2);
    localArrayList1.clear();
    a(localArrayList2, localArrayList1, true);
    return localArrayList1;
  }
  
  private void t(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---HCTopicMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("HCTopicMsgProc", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(msg_comm.Msg paramMsg, String paramString)
  {
    ajrk.f("HCTopicMsgProc", "processPush", new Object[] { paramString, paramMsg });
    if ((paramMsg == null) || (!paramMsg.msg_head.has())) {
      if (QLog.isColorLevel()) {
        ajrk.m("HCTopicMsgProc", new Object[] { "processPush invalidate params" });
      }
    }
    Object localObject1;
    Object localObject2;
    long l1;
    int j;
    long l4;
    int i;
    for (;;)
    {
      return;
      localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (!((msg_comm.MsgHead)localObject1).group_info.has())
      {
        if (QLog.isColorLevel()) {
          ajrk.m("HCTopicMsgProc", new Object[] { "<---handleMsgPush_PB_Group: no groupInfo." });
        }
      }
      else
      {
        localObject2 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
        l1 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
        long l2 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
        long l3 = ((msg_comm.GroupInfo)localObject2).group_code.get();
        j = ((msg_comm.GroupInfo)localObject2).group_type.get();
        l4 = Long.valueOf(this.app.getCurrentAccountUin()).longValue();
        if (l3 != 0L) {
          paramString = String.valueOf(l3);
        }
        localObject1 = this.app.a().a();
        if (((anba)localObject1).ed(paramString) == 2) {}
        for (i = 1; i == 0; i = 0)
        {
          ((anba)localObject1).u(paramString, new Object[] { paramMsg, paramString });
          return;
        }
        localObject2 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        Object localObject3 = new anbl();
        ((anbl)localObject3).friendUin = l3;
        ((anbl)localObject3).uinType = 1026;
        ((anbl)localObject3).dEX = j;
        try
        {
          a(paramMsg, (ArrayList)localObject2, (anbl)localObject3, false, null);
          jq((List)localObject2);
          achp.iZ((List)localObject2);
          if (((ArrayList)localObject2).size() == 0)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("HCTopicMsgProc", 2, "<---handleMsgPush_PB_Group : msg list is empty after decode.");
          }
        }
        catch (Exception paramMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("HCTopicMsgProc", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
            }
          }
          i = 0;
          while (i < ((ArrayList)localObject2).size())
          {
            paramMsg = (MessageRecord)((ArrayList)localObject2).get(i);
            if ((paramMsg != null) && (paramMsg.senderuin != null) && (paramMsg.senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin()))) {
              ab(paramMsg);
            }
            i += 1;
          }
          a((List)localObject2, localArrayList, true);
          ((ArrayList)localObject2).clear();
          int k = localArrayList.size();
          i = 0;
          if (i < k)
          {
            paramMsg = (MessageRecord)localArrayList.get(i);
            if (paramMsg.msgUid == 0L) {
              paramMsg.msgUid = l2;
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder("<---handleMsgPush_PB_Group : after analysis :");
              ((StringBuilder)localObject3).append("mr.senderuin:").append(paramMsg.senderuin).append(" mr.msgtype:").append(paramMsg.msgtype).append(" mr.msgUid:").append(paramMsg.msgUid).append(" mr.frienduin:").append(paramMsg.frienduin).append(" mr.shmsgseq:").append(paramMsg.shmsgseq).append(" mr.time:").append(paramMsg.time).append(" mr.msg:").append(paramMsg.getLogColorContent());
              QLog.d("HCTopicMsgProc", 2, ((StringBuilder)localObject3).toString());
            }
            if ((paramMsg.senderuin != null) && (paramMsg.senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin()))) {
              if (!ab(paramMsg)) {}
            }
            for (;;)
            {
              i += 1;
              break;
              paramMsg.isread = true;
              paramMsg.issend = 2;
              this.app.b().s(paramMsg.frienduin, 1026, paramMsg.shmsgseq);
              ((ArrayList)localObject2).add(paramMsg);
            }
          }
          bool = achp.F((ArrayList)localObject2);
          i = top.a((List)localObject2, this.app);
          paramMsg = this.app.b();
          if (!bool) {
            break label782;
          }
        }
      }
    }
    if (this.app.isBackground_Pause) {}
    label782:
    for (boolean bool = true;; bool = false)
    {
      paramMsg.c((ArrayList)localObject2, String.valueOf(l4), bool);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        ajpd.a((anba)localObject1, l1, paramString, 1);
        ((anba)localObject1).e(1, paramString, l1, 2);
      }
      if (j == 127) {
        break;
      }
      a("handleMsgPush_PB_Group", true, i, false, false);
      this.a.dI((ArrayList)localObject2);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, ArrayList<msg_comm.Msg> paramArrayList, String paramString2, long paramLong)
  {
    if (paramArrayList != null)
    {
      paramString2 = Integer.valueOf(paramArrayList.size());
      ajrk.f("HCTopicMsgProc", "processGetMsgs", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
      if (paramArrayList == null) {
        break label599;
      }
    }
    label599:
    for (paramArrayList = a(paramArrayList, paramString1);; paramArrayList = null)
    {
      int j = 0;
      long l2 = -9223372036854775808L;
      long l1 = 9223372036854775807L;
      String str = this.app.getCurrentUin();
      anba localanba = this.app.a().a();
      int i;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        Collections.sort(paramArrayList, this.w);
        paramString2 = new ArrayList();
        i = paramArrayList.size() - 1;
        label122:
        Object localObject;
        long l3;
        if (i >= 0)
        {
          localObject = (MessageRecord)paramArrayList.get(i);
          l3 = l2;
          if (l2 < ((MessageRecord)localObject).shmsgseq) {
            l3 = ((MessageRecord)localObject).shmsgseq;
          }
          l2 = l1;
          if (l1 > ((MessageRecord)localObject).shmsgseq) {
            l2 = ((MessageRecord)localObject).shmsgseq;
          }
          if ((((MessageRecord)localObject).senderuin != null) && (((MessageRecord)localObject).senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin())) && (ab((MessageRecord)localObject))) {}
          for (;;)
          {
            i -= 1;
            l1 = l2;
            l2 = l3;
            break label122;
            paramString2 = "null";
            break;
            paramString2.add(0, localObject);
          }
        }
        if (paramString2.size() > 0)
        {
          l3 = localanba.b(2, paramString1);
          paramArrayList = (tnu)this.app.b().a(1026);
          localObject = paramString2.iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            if (localMessageRecord != null)
            {
              if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin())))
              {
                localMessageRecord.isread = true;
                localMessageRecord.issend = 2;
              }
              if (l3 >= localMessageRecord.shmsgseq) {
                localMessageRecord.isread = true;
              }
            }
          }
          paramBoolean = achp.F(paramString2);
          j = top.a(paramString2, this.app);
          localObject = this.app.b();
          if ((paramBoolean) && (this.app.isBackground_Pause))
          {
            paramBoolean = true;
            ((QQMessageFacade)localObject).a(paramString2, str, paramBoolean, false);
            paramArrayList.k(paramString1, 1026, l3);
            paramArrayList.r(paramString1, paramString2);
            if (l2 != -9223372036854775808L) {
              ajpd.a(localanba, l2, paramString1, 3);
            }
            if (l1 != 9223372036854775807L)
            {
              localanba.e(1, paramString1, l1, 2);
              if (paramLong == 0L) {
                localanba.e(3, paramString1, l1, 1);
              }
            }
            i = 0;
            label506:
            paramArrayList = paramString2;
          }
        }
      }
      for (;;)
      {
        if ((i != 0) && (localanba.ed(paramString1) == 1))
        {
          paramLong = localanba.b(2, paramString1);
          ((tnu)this.app.b().a(1026)).k(paramString1, 1026, paramLong);
        }
        a("processGetMsgs", true, j, false, false);
        this.a.dI(paramArrayList);
        return;
        paramBoolean = false;
        break;
        i = 1;
        j = 0;
        break label506;
        i = 1;
      }
    }
  }
  
  protected boolean ab(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    MessageRecord localMessageRecord = this.app.b().a(paramMessageRecord.frienduin, 1026, paramMessageRecord);
    if (localMessageRecord != null)
    {
      if (this.app.a().aR(localMessageRecord)) {
        y(localMessageRecord);
      }
      if (!this.app.a().aww()) {
        this.app.a().e(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
      }
      this.a.b(paramMessageRecord.frienduin, 1026, localMessageRecord.uniseq, paramMessageRecord.shmsgseq, paramMessageRecord.time);
      ajpd.a(this.app.a().a(), paramMessageRecord.shmsgseq, paramMessageRecord.frienduin, 2);
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public void f(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: iload_1
    //   1: tableswitch	default:+27 -> 28, 1001:+28->29, 1002:+96->97, 1003:+96->97
    //   29: aload_2
    //   30: iconst_0
    //   31: aaload
    //   32: checkcast 90	msf/msgcomm/msg_comm$Msg
    //   35: astore 9
    //   37: aload_2
    //   38: iconst_1
    //   39: aaload
    //   40: checkcast 246	java/lang/String
    //   43: astore_2
    //   44: aload 9
    //   46: getfield 452	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   49: iconst_0
    //   50: invokevirtual 458	msf/msgcomm/msg_comm$AppShareInfo:setHasFlag	(Z)V
    //   53: iconst_1
    //   54: istore_3
    //   55: iload_3
    //   56: ifeq +28 -> 84
    //   59: aload_0
    //   60: aload 9
    //   62: aload_2
    //   63: invokevirtual 460	acqw:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/lang/String;)V
    //   66: return
    //   67: astore 10
    //   69: aconst_null
    //   70: astore 9
    //   72: aconst_null
    //   73: astore_2
    //   74: aload 10
    //   76: invokevirtual 463	java/lang/Exception:printStackTrace	()V
    //   79: iconst_0
    //   80: istore_3
    //   81: goto -26 -> 55
    //   84: aload_0
    //   85: aload_0
    //   86: invokevirtual 467	java/lang/Object:getClass	()Ljava/lang/Class;
    //   89: invokevirtual 472	java/lang/Class:getName	()Ljava/lang/String;
    //   92: iload_1
    //   93: invokevirtual 476	acqw:bN	(Ljava/lang/String;I)V
    //   96: return
    //   97: aconst_null
    //   98: astore 12
    //   100: lconst_0
    //   101: lstore 4
    //   103: new 24	java/util/ArrayList
    //   106: dup
    //   107: invokespecial 55	java/util/ArrayList:<init>	()V
    //   110: astore 10
    //   112: aload_0
    //   113: aload_2
    //   114: iconst_0
    //   115: aaload
    //   116: checkcast 24	java/util/ArrayList
    //   119: aload 10
    //   121: invokespecial 478	acqw:t	(Ljava/util/List;Ljava/util/List;)V
    //   124: aload_2
    //   125: iconst_1
    //   126: aaload
    //   127: checkcast 246	java/lang/String
    //   130: astore 9
    //   132: aload_2
    //   133: iconst_2
    //   134: aaload
    //   135: checkcast 246	java/lang/String
    //   138: astore 11
    //   140: aload_2
    //   141: iconst_3
    //   142: aaload
    //   143: checkcast 60	java/lang/Long
    //   146: invokevirtual 67	java/lang/Long:longValue	()J
    //   149: lstore 6
    //   151: lload 6
    //   153: lstore 4
    //   155: iconst_1
    //   156: istore 8
    //   158: aload 9
    //   160: astore_2
    //   161: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +55 -> 219
    //   167: ldc 36
    //   169: bipush 6
    //   171: anewarray 38	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: ldc_w 480
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: iload 8
    //   184: invokestatic 383	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   187: aastore
    //   188: dup
    //   189: iconst_2
    //   190: aload_2
    //   191: aastore
    //   192: dup
    //   193: iconst_3
    //   194: aload 11
    //   196: aastore
    //   197: dup
    //   198: iconst_4
    //   199: lload 4
    //   201: invokestatic 483	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   204: aastore
    //   205: dup
    //   206: iconst_5
    //   207: aload 10
    //   209: invokevirtual 28	java/util/ArrayList:size	()I
    //   212: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aastore
    //   216: invokestatic 52	ajrk:m	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: iload 8
    //   221: ifeq +55 -> 276
    //   224: iload_1
    //   225: sipush 1002
    //   228: if_icmpne +42 -> 270
    //   231: iconst_1
    //   232: istore 8
    //   234: aload_0
    //   235: iload 8
    //   237: aload_2
    //   238: aload 10
    //   240: aload 11
    //   242: lload 4
    //   244: invokevirtual 485	acqw:a	(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;J)V
    //   247: return
    //   248: astore 9
    //   250: aconst_null
    //   251: astore_2
    //   252: aconst_null
    //   253: astore 10
    //   255: aload 12
    //   257: astore 11
    //   259: aload 9
    //   261: invokevirtual 463	java/lang/Exception:printStackTrace	()V
    //   264: iconst_0
    //   265: istore 8
    //   267: goto -106 -> 161
    //   270: iconst_0
    //   271: istore 8
    //   273: goto -39 -> 234
    //   276: aload_0
    //   277: aload_0
    //   278: invokevirtual 467	java/lang/Object:getClass	()Ljava/lang/Class;
    //   281: invokevirtual 472	java/lang/Class:getName	()Ljava/lang/String;
    //   284: iload_1
    //   285: invokevirtual 476	acqw:bN	(Ljava/lang/String;I)V
    //   288: return
    //   289: astore 9
    //   291: aconst_null
    //   292: astore_2
    //   293: aload 12
    //   295: astore 11
    //   297: goto -38 -> 259
    //   300: astore 11
    //   302: aload 9
    //   304: astore_2
    //   305: aload 11
    //   307: astore 9
    //   309: aload 12
    //   311: astore 11
    //   313: goto -54 -> 259
    //   316: astore 12
    //   318: aload 9
    //   320: astore_2
    //   321: aload 12
    //   323: astore 9
    //   325: goto -66 -> 259
    //   328: astore 10
    //   330: aconst_null
    //   331: astore_2
    //   332: goto -258 -> 74
    //   335: astore 10
    //   337: goto -263 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	acqw
    //   0	340	1	paramInt	int
    //   0	340	2	paramVarArgs	Object[]
    //   54	27	3	i	int
    //   101	142	4	l1	long
    //   149	3	6	l2	long
    //   156	116	8	bool	boolean
    //   35	124	9	localObject1	Object
    //   248	12	9	localException1	Exception
    //   289	14	9	localException2	Exception
    //   307	17	9	localObject2	Object
    //   67	8	10	localException3	Exception
    //   110	144	10	localArrayList	ArrayList
    //   328	1	10	localException4	Exception
    //   335	1	10	localException5	Exception
    //   138	158	11	localObject3	Object
    //   300	6	11	localException6	Exception
    //   311	1	11	localObject4	Object
    //   98	212	12	localObject5	Object
    //   316	6	12	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   29	37	67	java/lang/Exception
    //   103	112	248	java/lang/Exception
    //   112	132	289	java/lang/Exception
    //   132	140	300	java/lang/Exception
    //   140	151	316	java/lang/Exception
    //   37	44	328	java/lang/Exception
    //   44	53	335	java/lang/Exception
  }
  
  protected void jq(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        ahyk localahyk = this.a.app.a(true).a(true);
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localahyk.ao((MessageRecord)paramList.next());
        }
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public void m(String paramString, int paramInt, long paramLong)
  {
    super.m(paramString, paramInt, paramLong);
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbGroupReadedReportReq localPbGroupReadedReportReq = new msg_svc.PbGroupReadedReportReq();
    localPbGroupReadedReportReq.group_code.set(Long.valueOf(paramString).longValue());
    localPbGroupReadedReportReq.last_read_seq.set(paramLong);
    localPbMsgReadedReportReq.grp_read_report.add(localPbGroupReadedReportReq);
    a(localPbMsgReadedReportReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqw
 * JD-Core Version:    0.7.0.1
 */