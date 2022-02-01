import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class akvi
  extends OGAbstractDao
{
  public akvi()
  {
    this.columnLen = 86;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (ExtensionInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.pendantId = paramCursor.getLong(paramCursor.getColumnIndex("pendantId"));
      paramEntity.pendantDiyId = paramCursor.getInt(paramCursor.getColumnIndex("pendantDiyId"));
      paramEntity.uVipFont = paramCursor.getLong(paramCursor.getColumnIndex("uVipFont"));
      paramEntity.vipFontType = paramCursor.getInt(paramCursor.getColumnIndex("vipFontType"));
      paramEntity.magicFont = paramCursor.getInt(paramCursor.getColumnIndex("magicFont"));
      paramEntity.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateTime"));
      paramEntity.fontEffect = paramCursor.getInt(paramCursor.getColumnIndex("fontEffect"));
      paramEntity.fontEffectLastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("fontEffectLastUpdateTime"));
      paramEntity.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramEntity.faceIdUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("faceIdUpdateTime"));
      paramEntity.colorRingId = paramCursor.getLong(paramCursor.getColumnIndex("colorRingId"));
      paramEntity.commingRingId = paramCursor.getLong(paramCursor.getColumnIndex("commingRingId"));
      paramEntity.timestamp = paramCursor.getLong(paramCursor.getColumnIndex("timestamp"));
      paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      paramEntity.feedType = paramCursor.getInt(paramCursor.getColumnIndex("feedType"));
      paramEntity.feedTime = paramCursor.getLong(paramCursor.getColumnIndex("feedTime"));
      paramEntity.feedContent = paramCursor.getString(paramCursor.getColumnIndex("feedContent"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("feedHasPhoto")))
      {
        paramBoolean = true;
        paramEntity.feedHasPhoto = paramBoolean;
        paramEntity.feedPhotoUrl = paramCursor.getString(paramCursor.getColumnIndex("feedPhotoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAdded2C2C"))) {
          break label1704;
        }
        paramBoolean = true;
        label421:
        paramEntity.isAdded2C2C = paramBoolean;
        paramEntity.chatInputType = paramCursor.getInt(paramCursor.getColumnIndex("chatInputType"));
        paramEntity.showC2CPanel = paramCursor.getInt(paramCursor.getColumnIndex("showC2CPanel"));
        paramEntity.pttChangeVoiceType = paramCursor.getInt(paramCursor.getColumnIndex("pttChangeVoiceType"));
        paramEntity.audioPanelType = paramCursor.getInt(paramCursor.getColumnIndex("audioPanelType"));
        paramEntity.openDoNotDisturbTime = paramCursor.getLong(paramCursor.getColumnIndex("openDoNotDisturbTime"));
        paramEntity.latestPLUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("latestPLUpdateTimestamp"));
        paramEntity.lastPullPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPullPLNewsTimestamp"));
        paramEntity.lastPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPLNewsTimestamp"));
        paramEntity.diyFontTimestampBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontTimestampBytes"));
        paramEntity.diyFontConfigBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontConfigBytes"));
        paramEntity.lastIceBreakCheckTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakCheckTs"));
        paramEntity.lastIceBreakChatTs = paramCursor.getLong(paramCursor.getColumnIndex("lastIceBreakChatTs"));
        paramEntity.makeFrdsTs = paramCursor.getLong(paramCursor.getColumnIndex("makeFrdsTs"));
        paramEntity.topPositionTime = paramCursor.getLong(paramCursor.getColumnIndex("topPositionTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isListenTogetherOpen"))) {
          break label1709;
        }
        paramBoolean = true;
        label698:
        paramEntity.isListenTogetherOpen = paramBoolean;
        paramEntity.isSharingLocation = paramCursor.getInt(paramCursor.getColumnIndex("isSharingLocation"));
        paramEntity.lastShareLbsMsgUniseq = paramCursor.getLong(paramCursor.getColumnIndex("lastShareLbsMsgUniseq"));
        paramEntity.mTogetherBusinessFlag = paramCursor.getLong(paramCursor.getColumnIndex("mTogetherBusinessFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnablePreview"))) {
          break label1714;
        }
        paramBoolean = true;
        label777:
        paramEntity.messageEnablePreview = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableSound"))) {
          break label1719;
        }
        paramBoolean = true;
        label802:
        paramEntity.messageEnableSound = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("messageEnableVibrate"))) {
          break label1724;
        }
        paramBoolean = true;
        label827:
        paramEntity.messageEnableVibrate = paramBoolean;
        paramEntity.friendRingId = paramCursor.getInt(paramCursor.getColumnIndex("friendRingId"));
        paramEntity.messageEnablePreviewNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnablePreviewNew"));
        paramEntity.messageEnableSoundNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableSoundNew"));
        paramEntity.messageEnableVibrateNew = paramCursor.getInt(paramCursor.getColumnIndex("messageEnableVibrateNew"));
        paramEntity.hiddenChatSwitch = paramCursor.getInt(paramCursor.getColumnIndex("hiddenChatSwitch"));
        paramEntity.intimate_type = paramCursor.getInt(paramCursor.getColumnIndex("intimate_type"));
        paramEntity.intimate_level = paramCursor.getInt(paramCursor.getColumnIndex("intimate_level"));
        paramEntity.intimate_chatDays = paramCursor.getInt(paramCursor.getColumnIndex("intimate_chatDays"));
        paramEntity.last_intimate_chatTime = paramCursor.getLong(paramCursor.getColumnIndex("last_intimate_chatTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isExtinguish"))) {
          break label1729;
        }
        paramBoolean = true;
        label1015:
        paramEntity.isExtinguish = paramBoolean;
        paramEntity.friendshipLevel = paramCursor.getInt(paramCursor.getColumnIndex("friendshipLevel"));
        paramEntity.friendshipChatDays = paramCursor.getInt(paramCursor.getColumnIndex("friendshipChatDays"));
        paramEntity.lastFriendshipTime = paramCursor.getLong(paramCursor.getColumnIndex("lastFriendshipTime"));
        paramEntity.chatHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("chatHotLevel"));
        paramEntity.chatDays = paramCursor.getInt(paramCursor.getColumnIndex("chatDays"));
        paramEntity.lastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("lastChatTime"));
        paramEntity.praiseHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("praiseHotLevel"));
        paramEntity.praiseDays = paramCursor.getInt(paramCursor.getColumnIndex("praiseDays"));
        paramEntity.lastpraiseTime = paramCursor.getLong(paramCursor.getColumnIndex("lastpraiseTime"));
        paramEntity.loverChatLevel = paramCursor.getInt(paramCursor.getColumnIndex("loverChatLevel"));
        paramEntity.loverChatDays = paramCursor.getInt(paramCursor.getColumnIndex("loverChatDays"));
        paramEntity.loverLastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("loverLastChatTime"));
        paramEntity.loverFlag = paramCursor.getInt(paramCursor.getColumnIndex("loverFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("loverTransFlag"))) {
          break label1734;
        }
        paramBoolean = true;
        label1288:
        paramEntity.loverTransFlag = paramBoolean;
        paramEntity.qzoneVisitType = paramCursor.getInt(paramCursor.getColumnIndex("qzoneVisitType"));
        paramEntity.qzoneHotDays = paramCursor.getInt(paramCursor.getColumnIndex("qzoneHotDays"));
        paramEntity.lastQzoneVisitTime = paramCursor.getLong(paramCursor.getColumnIndex("lastQzoneVisitTime"));
        paramEntity.bestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyType"));
        paramEntity.bestIntimacyDays = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyDays"));
        paramEntity.newBestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("newBestIntimacyType"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindChat"))) {
          break label1739;
        }
        paramBoolean = true;
        label1428:
        paramEntity.hasRemindChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindLoverChat"))) {
          break label1744;
        }
        paramBoolean = true;
        label1454:
        paramEntity.hasRemindLoverChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindPraise"))) {
          break label1749;
        }
        paramBoolean = true;
        label1480:
        paramEntity.hasRemindPraise = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindQzoneVisit"))) {
          break label1754;
        }
        paramBoolean = true;
        label1506:
        paramEntity.hasRemindQzoneVisit = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindFrdship"))) {
          break label1759;
        }
        paramBoolean = true;
        label1532:
        paramEntity.hasRemindFrdship = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindIntimate"))) {
          break label1764;
        }
      }
      label1704:
      label1709:
      label1714:
      label1719:
      label1724:
      label1729:
      label1734:
      label1739:
      label1744:
      label1749:
      label1754:
      label1759:
      label1764:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.hasRemindIntimate = paramBoolean;
        paramEntity.localChatSendTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatSendTs"));
        paramEntity.localChatRecTs = paramCursor.getLong(paramCursor.getColumnIndex("localChatRecTs"));
        paramEntity.lastHotReactiveReCheckInTs = paramCursor.getLong(paramCursor.getColumnIndex("lastHotReactiveReCheckInTs"));
        paramEntity.isGrayTipRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipRemind"));
        paramEntity.isGrayTipMultiRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipMultiRemind"));
        paramEntity.mutual_marks_store_json = paramCursor.getString(paramCursor.getColumnIndex("mutual_marks_store_json"));
        paramEntity.mutual_mark_version = paramCursor.getInt(paramCursor.getColumnIndex("mutual_mark_version"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label421;
        paramBoolean = false;
        break label698;
        paramBoolean = false;
        break label777;
        paramBoolean = false;
        break label802;
        paramBoolean = false;
        break label827;
        paramBoolean = false;
        break label1015;
        paramBoolean = false;
        break label1288;
        paramBoolean = false;
        break label1428;
        paramBoolean = false;
        break label1454;
        paramBoolean = false;
        break label1480;
        paramBoolean = false;
        break label1506;
        paramBoolean = false;
        break label1532;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("pendantId");
      if (i != -1) {
        break label4864;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pendantId", Long.TYPE));
      label1839:
      i = paramCursor.getColumnIndex("pendantDiyId");
      if (i != -1) {
        break label4879;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pendantDiyId", Integer.TYPE));
      label1874:
      i = paramCursor.getColumnIndex("uVipFont");
      if (i != -1) {
        break label4894;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uVipFont", Long.TYPE));
      label1909:
      i = paramCursor.getColumnIndex("vipFontType");
      if (i != -1) {
        break label4909;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vipFontType", Integer.TYPE));
      label1944:
      i = paramCursor.getColumnIndex("magicFont");
      if (i != -1) {
        break label4924;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("magicFont", Integer.TYPE));
      label1979:
      i = paramCursor.getColumnIndex("lastUpdateTime");
      if (i != -1) {
        break label4939;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastUpdateTime", Long.TYPE));
      label2014:
      i = paramCursor.getColumnIndex("fontEffect");
      if (i != -1) {
        break label4954;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontEffect", Integer.TYPE));
      label2049:
      i = paramCursor.getColumnIndex("fontEffectLastUpdateTime");
      if (i != -1) {
        break label4969;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("fontEffectLastUpdateTime", Long.TYPE));
      label2084:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label4984;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceId", Integer.TYPE));
      label2119:
      i = paramCursor.getColumnIndex("faceIdUpdateTime");
      if (i != -1) {
        break label4999;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceIdUpdateTime", Long.TYPE));
      label2154:
      i = paramCursor.getColumnIndex("colorRingId");
      if (i != -1) {
        break label5014;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("colorRingId", Long.TYPE));
      label2189:
      i = paramCursor.getColumnIndex("commingRingId");
      if (i != -1) {
        break label5029;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("commingRingId", Long.TYPE));
      label2224:
      i = paramCursor.getColumnIndex("timestamp");
      if (i != -1) {
        break label5044;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("timestamp", Long.TYPE));
      label2259:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label5059;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richTime", Long.TYPE));
      label2294:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label5074;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richBuffer", [B.class));
      label2329:
      i = paramCursor.getColumnIndex("feedType");
      if (i != -1) {
        break label5089;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedType", Integer.TYPE));
      label2364:
      i = paramCursor.getColumnIndex("feedTime");
      if (i != -1) {
        break label5104;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedTime", Long.TYPE));
      label2399:
      i = paramCursor.getColumnIndex("feedContent");
      if (i != -1) {
        break label5119;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedContent", String.class));
      label2434:
      i = paramCursor.getColumnIndex("feedHasPhoto");
      if (i != -1) {
        break label5134;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedHasPhoto", Boolean.TYPE));
      i = paramCursor.getColumnIndex("feedPhotoUrl");
      if (i != -1) {
        break label5161;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedPhotoUrl", String.class));
      label2504:
      i = paramCursor.getColumnIndex("isAdded2C2C");
      if (i != -1) {
        break label5176;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isAdded2C2C", Boolean.TYPE));
      i = paramCursor.getColumnIndex("chatInputType");
      if (i != -1) {
        break label5203;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("chatInputType", Integer.TYPE));
      label2574:
      i = paramCursor.getColumnIndex("showC2CPanel");
      if (i != -1) {
        break label5218;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("showC2CPanel", Integer.TYPE));
      label2609:
      i = paramCursor.getColumnIndex("pttChangeVoiceType");
      if (i != -1) {
        break label5233;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pttChangeVoiceType", Integer.TYPE));
      label2644:
      i = paramCursor.getColumnIndex("audioPanelType");
      if (i != -1) {
        break label5248;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("audioPanelType", Integer.TYPE));
      label2679:
      i = paramCursor.getColumnIndex("openDoNotDisturbTime");
      if (i != -1) {
        break label5263;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("openDoNotDisturbTime", Long.TYPE));
      label2714:
      i = paramCursor.getColumnIndex("latestPLUpdateTimestamp");
      if (i != -1) {
        break label5278;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("latestPLUpdateTimestamp", Long.TYPE));
      label2749:
      i = paramCursor.getColumnIndex("lastPullPLNewsTimestamp");
      if (i != -1) {
        break label5293;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastPullPLNewsTimestamp", Long.TYPE));
      label2784:
      i = paramCursor.getColumnIndex("lastPLNewsTimestamp");
      if (i != -1) {
        break label5308;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastPLNewsTimestamp", Long.TYPE));
      label2819:
      i = paramCursor.getColumnIndex("diyFontTimestampBytes");
      if (i != -1) {
        break label5323;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyFontTimestampBytes", [B.class));
      label2854:
      i = paramCursor.getColumnIndex("diyFontConfigBytes");
      if (i != -1) {
        break label5338;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diyFontConfigBytes", [B.class));
      label2889:
      i = paramCursor.getColumnIndex("lastIceBreakCheckTs");
      if (i != -1) {
        break label5353;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastIceBreakCheckTs", Long.TYPE));
      label2924:
      i = paramCursor.getColumnIndex("lastIceBreakChatTs");
      if (i != -1) {
        break label5368;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastIceBreakChatTs", Long.TYPE));
      label2959:
      i = paramCursor.getColumnIndex("makeFrdsTs");
      if (i != -1) {
        break label5383;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("makeFrdsTs", Long.TYPE));
      label2994:
      i = paramCursor.getColumnIndex("topPositionTime");
      if (i != -1) {
        break label5398;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("topPositionTime", Long.TYPE));
      label3029:
      i = paramCursor.getColumnIndex("isListenTogetherOpen");
      if (i != -1) {
        break label5413;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isListenTogetherOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isSharingLocation");
      if (i != -1) {
        break label5440;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSharingLocation", Integer.TYPE));
      label3099:
      i = paramCursor.getColumnIndex("lastShareLbsMsgUniseq");
      if (i != -1) {
        break label5455;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastShareLbsMsgUniseq", Long.TYPE));
      label3134:
      i = paramCursor.getColumnIndex("mTogetherBusinessFlag");
      if (i != -1) {
        break label5470;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTogetherBusinessFlag", Long.TYPE));
      label3169:
      i = paramCursor.getColumnIndex("messageEnablePreview");
      if (i != -1) {
        break label5485;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnablePreview", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableSound");
      if (i != -1) {
        break label5512;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnableSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("messageEnableVibrate");
      if (i != -1) {
        break label5539;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnableVibrate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendRingId");
      if (i != -1) {
        break label5566;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("friendRingId", Integer.TYPE));
      label3309:
      i = paramCursor.getColumnIndex("messageEnablePreviewNew");
      if (i != -1) {
        break label5581;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnablePreviewNew", Integer.TYPE));
      label3344:
      i = paramCursor.getColumnIndex("messageEnableSoundNew");
      if (i != -1) {
        break label5596;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnableSoundNew", Integer.TYPE));
      label3379:
      i = paramCursor.getColumnIndex("messageEnableVibrateNew");
      if (i != -1) {
        break label5611;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("messageEnableVibrateNew", Integer.TYPE));
      label3414:
      i = paramCursor.getColumnIndex("hiddenChatSwitch");
      if (i != -1) {
        break label5626;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hiddenChatSwitch", Integer.TYPE));
      label3449:
      i = paramCursor.getColumnIndex("intimate_type");
      if (i != -1) {
        break label5641;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("intimate_type", Integer.TYPE));
      label3484:
      i = paramCursor.getColumnIndex("intimate_level");
      if (i != -1) {
        break label5656;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("intimate_level", Integer.TYPE));
      label3519:
      i = paramCursor.getColumnIndex("intimate_chatDays");
      if (i != -1) {
        break label5671;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("intimate_chatDays", Integer.TYPE));
      label3554:
      i = paramCursor.getColumnIndex("last_intimate_chatTime");
      if (i != -1) {
        break label5686;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("last_intimate_chatTime", Long.TYPE));
      label3589:
      i = paramCursor.getColumnIndex("isExtinguish");
      if (i != -1) {
        break label5701;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isExtinguish", Boolean.TYPE));
      i = paramCursor.getColumnIndex("friendshipLevel");
      if (i != -1) {
        break label5728;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("friendshipLevel", Integer.TYPE));
      label3663:
      i = paramCursor.getColumnIndex("friendshipChatDays");
      if (i != -1) {
        break label5743;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("friendshipChatDays", Integer.TYPE));
      label3700:
      i = paramCursor.getColumnIndex("lastFriendshipTime");
      if (i != -1) {
        break label5758;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastFriendshipTime", Long.TYPE));
      label3737:
      i = paramCursor.getColumnIndex("chatHotLevel");
      if (i != -1) {
        break label5773;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("chatHotLevel", Integer.TYPE));
      label3774:
      i = paramCursor.getColumnIndex("chatDays");
      if (i != -1) {
        break label5788;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("chatDays", Integer.TYPE));
      label3811:
      i = paramCursor.getColumnIndex("lastChatTime");
      if (i != -1) {
        break label5803;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastChatTime", Long.TYPE));
      label3848:
      i = paramCursor.getColumnIndex("praiseHotLevel");
      if (i != -1) {
        break label5818;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("praiseHotLevel", Integer.TYPE));
      label3885:
      i = paramCursor.getColumnIndex("praiseDays");
      if (i != -1) {
        break label5833;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("praiseDays", Integer.TYPE));
      label3922:
      i = paramCursor.getColumnIndex("lastpraiseTime");
      if (i != -1) {
        break label5848;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastpraiseTime", Long.TYPE));
      label3959:
      i = paramCursor.getColumnIndex("loverChatLevel");
      if (i != -1) {
        break label5863;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loverChatLevel", Integer.TYPE));
      label3996:
      i = paramCursor.getColumnIndex("loverChatDays");
      if (i != -1) {
        break label5878;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loverChatDays", Integer.TYPE));
      label4033:
      i = paramCursor.getColumnIndex("loverLastChatTime");
      if (i != -1) {
        break label5893;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loverLastChatTime", Long.TYPE));
      label4070:
      i = paramCursor.getColumnIndex("loverFlag");
      if (i != -1) {
        break label5908;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loverFlag", Integer.TYPE));
      label4107:
      i = paramCursor.getColumnIndex("loverTransFlag");
      if (i != -1) {
        break label5923;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loverTransFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("qzoneVisitType");
      if (i != -1) {
        break label5950;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzoneVisitType", Integer.TYPE));
      label4181:
      i = paramCursor.getColumnIndex("qzoneHotDays");
      if (i != -1) {
        break label5965;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzoneHotDays", Integer.TYPE));
      label4218:
      i = paramCursor.getColumnIndex("lastQzoneVisitTime");
      if (i != -1) {
        break label5980;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastQzoneVisitTime", Long.TYPE));
      label4255:
      i = paramCursor.getColumnIndex("bestIntimacyType");
      if (i != -1) {
        break label5995;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bestIntimacyType", Integer.TYPE));
      label4292:
      i = paramCursor.getColumnIndex("bestIntimacyDays");
      if (i != -1) {
        break label6010;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bestIntimacyDays", Integer.TYPE));
      label4329:
      i = paramCursor.getColumnIndex("newBestIntimacyType");
      if (i != -1) {
        break label6025;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newBestIntimacyType", Integer.TYPE));
      label4366:
      i = paramCursor.getColumnIndex("hasRemindChat");
      if (i != -1) {
        break label6040;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindLoverChat");
      if (i != -1) {
        break label6067;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindLoverChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindPraise");
      if (i != -1) {
        break label6094;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindPraise", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindQzoneVisit");
      if (i != -1) {
        break label6121;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindQzoneVisit", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindFrdship");
      if (i != -1) {
        break label6148;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindFrdship", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindIntimate");
      if (i != -1) {
        break label6175;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasRemindIntimate", Boolean.TYPE));
      i = paramCursor.getColumnIndex("localChatSendTs");
      if (i != -1) {
        break label6203;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("localChatSendTs", Long.TYPE));
      label4625:
      i = paramCursor.getColumnIndex("localChatRecTs");
      if (i != -1) {
        break label6218;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("localChatRecTs", Long.TYPE));
      label4662:
      i = paramCursor.getColumnIndex("lastHotReactiveReCheckInTs");
      if (i != -1) {
        break label6233;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastHotReactiveReCheckInTs", Long.TYPE));
      label4699:
      i = paramCursor.getColumnIndex("isGrayTipRemind");
      if (i != -1) {
        break label6248;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isGrayTipRemind", Integer.TYPE));
      label4736:
      i = paramCursor.getColumnIndex("isGrayTipMultiRemind");
      if (i != -1) {
        break label6263;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isGrayTipMultiRemind", Integer.TYPE));
      label4773:
      i = paramCursor.getColumnIndex("mutual_marks_store_json");
      if (i != -1) {
        break label6278;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mutual_marks_store_json", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mutual_mark_version");
      if (i != -1) {
        break label6293;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mutual_mark_version", Integer.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label4864:
      paramEntity.pendantId = paramCursor.getLong(i);
      break label1839;
      label4879:
      paramEntity.pendantDiyId = paramCursor.getInt(i);
      break label1874;
      label4894:
      paramEntity.uVipFont = paramCursor.getLong(i);
      break label1909;
      label4909:
      paramEntity.vipFontType = paramCursor.getInt(i);
      break label1944;
      label4924:
      paramEntity.magicFont = paramCursor.getInt(i);
      break label1979;
      label4939:
      paramEntity.lastUpdateTime = paramCursor.getLong(i);
      break label2014;
      label4954:
      paramEntity.fontEffect = paramCursor.getInt(i);
      break label2049;
      label4969:
      paramEntity.fontEffectLastUpdateTime = paramCursor.getLong(i);
      break label2084;
      label4984:
      paramEntity.faceId = paramCursor.getInt(i);
      break label2119;
      label4999:
      paramEntity.faceIdUpdateTime = paramCursor.getLong(i);
      break label2154;
      label5014:
      paramEntity.colorRingId = paramCursor.getLong(i);
      break label2189;
      label5029:
      paramEntity.commingRingId = paramCursor.getLong(i);
      break label2224;
      label5044:
      paramEntity.timestamp = paramCursor.getLong(i);
      break label2259;
      label5059:
      paramEntity.richTime = paramCursor.getLong(i);
      break label2294;
      label5074:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label2329;
      label5089:
      paramEntity.feedType = paramCursor.getInt(i);
      break label2364;
      label5104:
      paramEntity.feedTime = paramCursor.getLong(i);
      break label2399;
      label5119:
      paramEntity.feedContent = paramCursor.getString(i);
      break label2434;
      label5134:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.feedHasPhoto = paramBoolean;
        break;
      }
      label5161:
      paramEntity.feedPhotoUrl = paramCursor.getString(i);
      break label2504;
      label5176:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isAdded2C2C = paramBoolean;
        break;
      }
      label5203:
      paramEntity.chatInputType = paramCursor.getInt(i);
      break label2574;
      label5218:
      paramEntity.showC2CPanel = paramCursor.getInt(i);
      break label2609;
      label5233:
      paramEntity.pttChangeVoiceType = paramCursor.getInt(i);
      break label2644;
      label5248:
      paramEntity.audioPanelType = paramCursor.getInt(i);
      break label2679;
      label5263:
      paramEntity.openDoNotDisturbTime = paramCursor.getLong(i);
      break label2714;
      label5278:
      paramEntity.latestPLUpdateTimestamp = paramCursor.getLong(i);
      break label2749;
      label5293:
      paramEntity.lastPullPLNewsTimestamp = paramCursor.getLong(i);
      break label2784;
      label5308:
      paramEntity.lastPLNewsTimestamp = paramCursor.getLong(i);
      break label2819;
      label5323:
      paramEntity.diyFontTimestampBytes = paramCursor.getBlob(i);
      break label2854;
      label5338:
      paramEntity.diyFontConfigBytes = paramCursor.getBlob(i);
      break label2889;
      label5353:
      paramEntity.lastIceBreakCheckTs = paramCursor.getLong(i);
      break label2924;
      label5368:
      paramEntity.lastIceBreakChatTs = paramCursor.getLong(i);
      break label2959;
      label5383:
      paramEntity.makeFrdsTs = paramCursor.getLong(i);
      break label2994;
      label5398:
      paramEntity.topPositionTime = paramCursor.getLong(i);
      break label3029;
      label5413:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isListenTogetherOpen = paramBoolean;
        break;
      }
      label5440:
      paramEntity.isSharingLocation = paramCursor.getInt(i);
      break label3099;
      label5455:
      paramEntity.lastShareLbsMsgUniseq = paramCursor.getLong(i);
      break label3134;
      label5470:
      paramEntity.mTogetherBusinessFlag = paramCursor.getLong(i);
      break label3169;
      label5485:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.messageEnablePreview = paramBoolean;
        break;
      }
      label5512:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.messageEnableSound = paramBoolean;
        break;
      }
      label5539:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.messageEnableVibrate = paramBoolean;
        break;
      }
      label5566:
      paramEntity.friendRingId = paramCursor.getInt(i);
      break label3309;
      label5581:
      paramEntity.messageEnablePreviewNew = paramCursor.getInt(i);
      break label3344;
      label5596:
      paramEntity.messageEnableSoundNew = paramCursor.getInt(i);
      break label3379;
      label5611:
      paramEntity.messageEnableVibrateNew = paramCursor.getInt(i);
      break label3414;
      label5626:
      paramEntity.hiddenChatSwitch = paramCursor.getInt(i);
      break label3449;
      label5641:
      paramEntity.intimate_type = paramCursor.getInt(i);
      break label3484;
      label5656:
      paramEntity.intimate_level = paramCursor.getInt(i);
      break label3519;
      label5671:
      paramEntity.intimate_chatDays = paramCursor.getInt(i);
      break label3554;
      label5686:
      paramEntity.last_intimate_chatTime = paramCursor.getLong(i);
      break label3589;
      label5701:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isExtinguish = paramBoolean;
        break;
      }
      label5728:
      paramEntity.friendshipLevel = paramCursor.getInt(i);
      break label3663;
      label5743:
      paramEntity.friendshipChatDays = paramCursor.getInt(i);
      break label3700;
      label5758:
      paramEntity.lastFriendshipTime = paramCursor.getLong(i);
      break label3737;
      label5773:
      paramEntity.chatHotLevel = paramCursor.getInt(i);
      break label3774;
      label5788:
      paramEntity.chatDays = paramCursor.getInt(i);
      break label3811;
      label5803:
      paramEntity.lastChatTime = paramCursor.getLong(i);
      break label3848;
      label5818:
      paramEntity.praiseHotLevel = paramCursor.getInt(i);
      break label3885;
      label5833:
      paramEntity.praiseDays = paramCursor.getInt(i);
      break label3922;
      label5848:
      paramEntity.lastpraiseTime = paramCursor.getLong(i);
      break label3959;
      label5863:
      paramEntity.loverChatLevel = paramCursor.getInt(i);
      break label3996;
      label5878:
      paramEntity.loverChatDays = paramCursor.getInt(i);
      break label4033;
      label5893:
      paramEntity.loverLastChatTime = paramCursor.getLong(i);
      break label4070;
      label5908:
      paramEntity.loverFlag = paramCursor.getInt(i);
      break label4107;
      label5923:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.loverTransFlag = paramBoolean;
        break;
      }
      label5950:
      paramEntity.qzoneVisitType = paramCursor.getInt(i);
      break label4181;
      label5965:
      paramEntity.qzoneHotDays = paramCursor.getInt(i);
      break label4218;
      label5980:
      paramEntity.lastQzoneVisitTime = paramCursor.getLong(i);
      break label4255;
      label5995:
      paramEntity.bestIntimacyType = paramCursor.getInt(i);
      break label4292;
      label6010:
      paramEntity.bestIntimacyDays = paramCursor.getInt(i);
      break label4329;
      label6025:
      paramEntity.newBestIntimacyType = paramCursor.getInt(i);
      break label4366;
      label6040:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindChat = paramBoolean;
        break;
      }
      label6067:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindLoverChat = paramBoolean;
        break;
      }
      label6094:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindPraise = paramBoolean;
        break;
      }
      label6121:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindQzoneVisit = paramBoolean;
        break;
      }
      label6148:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindFrdship = paramBoolean;
        break;
      }
      label6175:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.hasRemindIntimate = paramBoolean;
        break;
      }
      label6203:
      paramEntity.localChatSendTs = paramCursor.getLong(i);
      break label4625;
      label6218:
      paramEntity.localChatRecTs = paramCursor.getLong(i);
      break label4662;
      label6233:
      paramEntity.lastHotReactiveReCheckInTs = paramCursor.getLong(i);
      break label4699;
      label6248:
      paramEntity.isGrayTipRemind = paramCursor.getInt(i);
      break label4736;
      label6263:
      paramEntity.isGrayTipMultiRemind = paramCursor.getInt(i);
      break label4773;
      label6278:
      paramEntity.mutual_marks_store_json = paramCursor.getString(i);
    }
    label6293:
    paramEntity.mutual_mark_version = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ExtensionInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("pendantId", Long.valueOf(paramEntity.pendantId));
    paramContentValues.put("pendantDiyId", Integer.valueOf(paramEntity.pendantDiyId));
    paramContentValues.put("uVipFont", Long.valueOf(paramEntity.uVipFont));
    paramContentValues.put("vipFontType", Integer.valueOf(paramEntity.vipFontType));
    paramContentValues.put("magicFont", Integer.valueOf(paramEntity.magicFont));
    paramContentValues.put("lastUpdateTime", Long.valueOf(paramEntity.lastUpdateTime));
    paramContentValues.put("fontEffect", Integer.valueOf(paramEntity.fontEffect));
    paramContentValues.put("fontEffectLastUpdateTime", Long.valueOf(paramEntity.fontEffectLastUpdateTime));
    paramContentValues.put("faceId", Integer.valueOf(paramEntity.faceId));
    paramContentValues.put("faceIdUpdateTime", Long.valueOf(paramEntity.faceIdUpdateTime));
    paramContentValues.put("colorRingId", Long.valueOf(paramEntity.colorRingId));
    paramContentValues.put("commingRingId", Long.valueOf(paramEntity.commingRingId));
    paramContentValues.put("timestamp", Long.valueOf(paramEntity.timestamp));
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("feedType", Integer.valueOf(paramEntity.feedType));
    paramContentValues.put("feedTime", Long.valueOf(paramEntity.feedTime));
    paramContentValues.put("feedContent", paramEntity.feedContent);
    paramContentValues.put("feedHasPhoto", Boolean.valueOf(paramEntity.feedHasPhoto));
    paramContentValues.put("feedPhotoUrl", paramEntity.feedPhotoUrl);
    paramContentValues.put("isAdded2C2C", Boolean.valueOf(paramEntity.isAdded2C2C));
    paramContentValues.put("chatInputType", Integer.valueOf(paramEntity.chatInputType));
    paramContentValues.put("showC2CPanel", Integer.valueOf(paramEntity.showC2CPanel));
    paramContentValues.put("pttChangeVoiceType", Integer.valueOf(paramEntity.pttChangeVoiceType));
    paramContentValues.put("audioPanelType", Integer.valueOf(paramEntity.audioPanelType));
    paramContentValues.put("openDoNotDisturbTime", Long.valueOf(paramEntity.openDoNotDisturbTime));
    paramContentValues.put("latestPLUpdateTimestamp", Long.valueOf(paramEntity.latestPLUpdateTimestamp));
    paramContentValues.put("lastPullPLNewsTimestamp", Long.valueOf(paramEntity.lastPullPLNewsTimestamp));
    paramContentValues.put("lastPLNewsTimestamp", Long.valueOf(paramEntity.lastPLNewsTimestamp));
    paramContentValues.put("diyFontTimestampBytes", paramEntity.diyFontTimestampBytes);
    paramContentValues.put("diyFontConfigBytes", paramEntity.diyFontConfigBytes);
    paramContentValues.put("lastIceBreakCheckTs", Long.valueOf(paramEntity.lastIceBreakCheckTs));
    paramContentValues.put("lastIceBreakChatTs", Long.valueOf(paramEntity.lastIceBreakChatTs));
    paramContentValues.put("makeFrdsTs", Long.valueOf(paramEntity.makeFrdsTs));
    paramContentValues.put("topPositionTime", Long.valueOf(paramEntity.topPositionTime));
    paramContentValues.put("isListenTogetherOpen", Boolean.valueOf(paramEntity.isListenTogetherOpen));
    paramContentValues.put("isSharingLocation", Integer.valueOf(paramEntity.isSharingLocation));
    paramContentValues.put("lastShareLbsMsgUniseq", Long.valueOf(paramEntity.lastShareLbsMsgUniseq));
    paramContentValues.put("mTogetherBusinessFlag", Long.valueOf(paramEntity.mTogetherBusinessFlag));
    paramContentValues.put("messageEnablePreview", Boolean.valueOf(paramEntity.messageEnablePreview));
    paramContentValues.put("messageEnableSound", Boolean.valueOf(paramEntity.messageEnableSound));
    paramContentValues.put("messageEnableVibrate", Boolean.valueOf(paramEntity.messageEnableVibrate));
    paramContentValues.put("friendRingId", Integer.valueOf(paramEntity.friendRingId));
    paramContentValues.put("messageEnablePreviewNew", Integer.valueOf(paramEntity.messageEnablePreviewNew));
    paramContentValues.put("messageEnableSoundNew", Integer.valueOf(paramEntity.messageEnableSoundNew));
    paramContentValues.put("messageEnableVibrateNew", Integer.valueOf(paramEntity.messageEnableVibrateNew));
    paramContentValues.put("hiddenChatSwitch", Integer.valueOf(paramEntity.hiddenChatSwitch));
    paramContentValues.put("intimate_type", Integer.valueOf(paramEntity.intimate_type));
    paramContentValues.put("intimate_level", Integer.valueOf(paramEntity.intimate_level));
    paramContentValues.put("intimate_chatDays", Integer.valueOf(paramEntity.intimate_chatDays));
    paramContentValues.put("last_intimate_chatTime", Long.valueOf(paramEntity.last_intimate_chatTime));
    paramContentValues.put("isExtinguish", Boolean.valueOf(paramEntity.isExtinguish));
    paramContentValues.put("friendshipLevel", Integer.valueOf(paramEntity.friendshipLevel));
    paramContentValues.put("friendshipChatDays", Integer.valueOf(paramEntity.friendshipChatDays));
    paramContentValues.put("lastFriendshipTime", Long.valueOf(paramEntity.lastFriendshipTime));
    paramContentValues.put("chatHotLevel", Integer.valueOf(paramEntity.chatHotLevel));
    paramContentValues.put("chatDays", Integer.valueOf(paramEntity.chatDays));
    paramContentValues.put("lastChatTime", Long.valueOf(paramEntity.lastChatTime));
    paramContentValues.put("praiseHotLevel", Integer.valueOf(paramEntity.praiseHotLevel));
    paramContentValues.put("praiseDays", Integer.valueOf(paramEntity.praiseDays));
    paramContentValues.put("lastpraiseTime", Long.valueOf(paramEntity.lastpraiseTime));
    paramContentValues.put("loverChatLevel", Integer.valueOf(paramEntity.loverChatLevel));
    paramContentValues.put("loverChatDays", Integer.valueOf(paramEntity.loverChatDays));
    paramContentValues.put("loverLastChatTime", Long.valueOf(paramEntity.loverLastChatTime));
    paramContentValues.put("loverFlag", Integer.valueOf(paramEntity.loverFlag));
    paramContentValues.put("loverTransFlag", Boolean.valueOf(paramEntity.loverTransFlag));
    paramContentValues.put("qzoneVisitType", Integer.valueOf(paramEntity.qzoneVisitType));
    paramContentValues.put("qzoneHotDays", Integer.valueOf(paramEntity.qzoneHotDays));
    paramContentValues.put("lastQzoneVisitTime", Long.valueOf(paramEntity.lastQzoneVisitTime));
    paramContentValues.put("bestIntimacyType", Integer.valueOf(paramEntity.bestIntimacyType));
    paramContentValues.put("bestIntimacyDays", Integer.valueOf(paramEntity.bestIntimacyDays));
    paramContentValues.put("newBestIntimacyType", Integer.valueOf(paramEntity.newBestIntimacyType));
    paramContentValues.put("hasRemindChat", Boolean.valueOf(paramEntity.hasRemindChat));
    paramContentValues.put("hasRemindLoverChat", Boolean.valueOf(paramEntity.hasRemindLoverChat));
    paramContentValues.put("hasRemindPraise", Boolean.valueOf(paramEntity.hasRemindPraise));
    paramContentValues.put("hasRemindQzoneVisit", Boolean.valueOf(paramEntity.hasRemindQzoneVisit));
    paramContentValues.put("hasRemindFrdship", Boolean.valueOf(paramEntity.hasRemindFrdship));
    paramContentValues.put("hasRemindIntimate", Boolean.valueOf(paramEntity.hasRemindIntimate));
    paramContentValues.put("localChatSendTs", Long.valueOf(paramEntity.localChatSendTs));
    paramContentValues.put("localChatRecTs", Long.valueOf(paramEntity.localChatRecTs));
    paramContentValues.put("lastHotReactiveReCheckInTs", Long.valueOf(paramEntity.lastHotReactiveReCheckInTs));
    paramContentValues.put("isGrayTipRemind", Integer.valueOf(paramEntity.isGrayTipRemind));
    paramContentValues.put("isGrayTipMultiRemind", Integer.valueOf(paramEntity.isGrayTipMultiRemind));
    paramContentValues.put("mutual_marks_store_json", paramEntity.mutual_marks_store_json);
    paramContentValues.put("mutual_mark_version", Integer.valueOf(paramEntity.mutual_mark_version));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,pendantId INTEGER ,pendantDiyId INTEGER ,uVipFont INTEGER ,vipFontType INTEGER ,magicFont INTEGER ,lastUpdateTime INTEGER ,fontEffect INTEGER ,fontEffectLastUpdateTime INTEGER ,faceId INTEGER ,faceIdUpdateTime INTEGER ,colorRingId INTEGER ,commingRingId INTEGER ,timestamp INTEGER ,richTime INTEGER ,richBuffer BLOB ,feedType INTEGER ,feedTime INTEGER ,feedContent TEXT ,feedHasPhoto INTEGER ,feedPhotoUrl TEXT ,isAdded2C2C INTEGER ,chatInputType INTEGER ,showC2CPanel INTEGER ,pttChangeVoiceType INTEGER ,audioPanelType INTEGER ,openDoNotDisturbTime INTEGER ,latestPLUpdateTimestamp INTEGER ,lastPullPLNewsTimestamp INTEGER ,lastPLNewsTimestamp INTEGER ,diyFontTimestampBytes BLOB ,diyFontConfigBytes BLOB ,lastIceBreakCheckTs INTEGER ,lastIceBreakChatTs INTEGER ,makeFrdsTs INTEGER ,topPositionTime INTEGER ,isListenTogetherOpen INTEGER ,isSharingLocation INTEGER ,lastShareLbsMsgUniseq INTEGER ,mTogetherBusinessFlag INTEGER ,messageEnablePreview INTEGER ,messageEnableSound INTEGER ,messageEnableVibrate INTEGER ,friendRingId INTEGER ,messageEnablePreviewNew INTEGER ,messageEnableSoundNew INTEGER ,messageEnableVibrateNew INTEGER ,hiddenChatSwitch INTEGER ,intimate_type INTEGER ,intimate_level INTEGER ,intimate_chatDays INTEGER ,last_intimate_chatTime INTEGER ,isExtinguish INTEGER ,friendshipLevel INTEGER ,friendshipChatDays INTEGER ,lastFriendshipTime INTEGER ,chatHotLevel INTEGER ,chatDays INTEGER ,lastChatTime INTEGER ,praiseHotLevel INTEGER ,praiseDays INTEGER ,lastpraiseTime INTEGER ,loverChatLevel INTEGER ,loverChatDays INTEGER ,loverLastChatTime INTEGER ,loverFlag INTEGER ,loverTransFlag INTEGER ,qzoneVisitType INTEGER ,qzoneHotDays INTEGER ,lastQzoneVisitTime INTEGER ,bestIntimacyType INTEGER ,bestIntimacyDays INTEGER ,newBestIntimacyType INTEGER ,hasRemindChat INTEGER ,hasRemindLoverChat INTEGER ,hasRemindPraise INTEGER ,hasRemindQzoneVisit INTEGER ,hasRemindFrdship INTEGER ,hasRemindIntimate INTEGER ,localChatSendTs INTEGER ,localChatRecTs INTEGER ,lastHotReactiveReCheckInTs INTEGER ,isGrayTipRemind INTEGER ,isGrayTipMultiRemind INTEGER ,mutual_marks_store_json TEXT ,mutual_mark_version INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akvi
 * JD-Core Version:    0.7.0.1
 */