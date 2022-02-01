package com.tencent.moai.mailsdk.protocol.activesync.Status;

public class CommonStatus
  extends ActiveSyncStatus
{
  public static final String CommonStatus_0 = "Default.";
  public static final String CommonStatus_1 = "Success.";
  public static final String CommonStatus_101 = "InvalidContent";
  public static final String CommonStatus_102 = "InvalidWBXML";
  public static final String CommonStatus_103 = "InvalidXML";
  public static final String CommonStatus_104 = "InvalidDateTime";
  public static final String CommonStatus_105 = "InvalidCombinationOfIDs";
  public static final String CommonStatus_106 = "InvalidIDs";
  public static final String CommonStatus_107 = "InvalidMIME";
  public static final String CommonStatus_108 = "DeviceIdMissingOrInvalid";
  public static final String CommonStatus_109 = "DeviceTypeMissingOrInvalid";
  public static final String CommonStatus_110 = "ServerError";
  public static final String CommonStatus_111 = "ServerErrorRetryLater";
  public static final String CommonStatus_112 = "ActiveDirectoryAccessDenied";
  public static final String CommonStatus_113 = "MailboxQuotaExceeded";
  public static final String CommonStatus_114 = "MailboxServerOffline";
  public static final String CommonStatus_115 = "SendQuotaExceeded";
  public static final String CommonStatus_116 = "MessageRecipientUnresolved";
  public static final String CommonStatus_117 = "MessageReplyNotAllowed";
  public static final String CommonStatus_118 = "MessagePreviouslySent";
  public static final String CommonStatus_119 = "MessageHasNoRecipient";
  public static final String CommonStatus_120 = "MailSubmissionFailed";
  public static final String CommonStatus_121 = "MessageReplyFailed";
  public static final String CommonStatus_122 = "AttachmentIsTooLarge";
  public static final String CommonStatus_123 = "UserHasNoMailbox";
  public static final String CommonStatus_124 = "UserCannotBeAnonymous";
  public static final String CommonStatus_125 = "UserPrincipalCouldNotBeFound";
  public static final String CommonStatus_126 = "UserDisabledForSync";
  public static final String CommonStatus_127 = "UserOnNewMailboxCannotSync";
  public static final String CommonStatus_128 = "UserOnLegacyMailboxCannotSync";
  public static final String CommonStatus_129 = "DeviceIsBlockedForThisUser";
  public static final String CommonStatus_130 = "AccessDenied";
  public static final String CommonStatus_131 = "AccountDisabled";
  public static final String CommonStatus_132 = "SyncStateNotFound";
  public static final String CommonStatus_133 = "SyncStateLocked";
  public static final String CommonStatus_134 = "SyncStateCorrupt";
  public static final String CommonStatus_135 = "SyncStateAlreadyExists";
  public static final String CommonStatus_136 = "SyncStateVersionInvalid";
  public static final String CommonStatus_137 = "CommandNotSupported";
  public static final String CommonStatus_138 = "VersionNotSupported";
  public static final String CommonStatus_139 = "DeviceNotFullyProvisionable";
  public static final String CommonStatus_140 = "RemoteWipeRequested";
  public static final String CommonStatus_141 = "LegacyDeviceOnStrictPolicy";
  public static final String CommonStatus_142 = "DeviceNotProvisioned";
  public static final String CommonStatus_143 = "PolicyRefresh";
  public static final String CommonStatus_144 = "InvalidPolicyKey";
  public static final String CommonStatus_145 = "ExternallyManagedDevicesNotAllowed";
  public static final String CommonStatus_146 = "NoRecurrenceInCalendar";
  public static final String CommonStatus_147 = "UnexpectedItemClass";
  public static final String CommonStatus_148 = "RemoteServerHasNoSSL";
  public static final String CommonStatus_149 = "InvalidStoredRequest";
  public static final String CommonStatus_150 = "ItemNotFound";
  public static final String CommonStatus_151 = "TooManyFolders";
  public static final String CommonStatus_152 = "NoFoldersFound";
  public static final String CommonStatus_153 = "ItemsLostAfterMove";
  public static final String CommonStatus_154 = "FailureInMoveOperation";
  public static final String CommonStatus_155 = "MoveCommandDisallowedForNonPersistentMoveAction";
  public static final String CommonStatus_156 = "MoveCommandInvalidDestinationFolder";
  public static final String CommonStatus_160 = "AvailabilityTooManyRecipients";
  public static final String CommonStatus_161 = "AvailabilityDLLimitReached";
  public static final String CommonStatus_162 = "AvailabilityTransientFailure";
  public static final String CommonStatus_163 = "AvailabilityFailure";
  public static final String CommonStatus_164 = "BodyPartPreferenceTypeNotSupported";
  public static final String CommonStatus_165 = "DeviceInformationRequired";
  public static final String CommonStatus_166 = "InvalidAccountId";
  public static final String CommonStatus_167 = "AccountSendDisabled";
  public static final String CommonStatus_168 = "IRM_FeatureDisabled";
  public static final String CommonStatus_169 = "IRM_TransientError";
  public static final String CommonStatus_170 = "IRM_PermanentError";
  public static final String CommonStatus_171 = "IRM_InvalidTemplateID";
  public static final String CommonStatus_172 = "IRM_OperationNotPermitted";
  public static final String CommonStatus_173 = "NoPicture";
  public static final String CommonStatus_174 = "PictureTooLarge";
  public static final String CommonStatus_175 = "PictureLimitReached";
  public static final String CommonStatus_176 = "BodyPart_ConversationTooLarge";
  public static final String CommonStatus_177 = "MaximumDevicesReached";
  public static final String CommonStatus_178 = "InvalidMimeBodyCombination";
  public static final String CommonStatus_179 = "InvalidSmartForwardParameters";
  public static final String CommonStatus_183 = "InvalidRecipients";
  public static final String CommonStatus_184 = "OneOrMoreExceptionFailed";
  
  public CommonStatus(int paramInt)
  {
    super(paramInt);
  }
  
  public String getStatusMsg()
  {
    switch (this.status)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
    case 96: 
    case 97: 
    case 98: 
    case 99: 
    case 100: 
    case 157: 
    case 158: 
    case 159: 
    case 180: 
    case 181: 
    case 182: 
    default: 
      return "Default.";
    case 1: 
      return "Success.";
    case 101: 
      return "InvalidContent";
    case 102: 
      return "InvalidWBXML";
    case 103: 
      return "InvalidXML";
    case 104: 
      return "InvalidDateTime";
    case 105: 
      return "InvalidCombinationOfIDs";
    case 106: 
      return "InvalidIDs";
    case 107: 
      return "InvalidMIME";
    case 108: 
      return "DeviceIdMissingOrInvalid";
    case 109: 
      return "DeviceTypeMissingOrInvalid";
    case 110: 
      return "ServerError";
    case 111: 
      return "ServerErrorRetryLater";
    case 112: 
      return "ActiveDirectoryAccessDenied";
    case 113: 
      return "MailboxQuotaExceeded";
    case 114: 
      return "MailboxServerOffline";
    case 115: 
      return "SendQuotaExceeded";
    case 116: 
      return "MessageRecipientUnresolved";
    case 117: 
      return "MessageReplyNotAllowed";
    case 118: 
      return "MessagePreviouslySent";
    case 119: 
      return "MessageHasNoRecipient";
    case 120: 
      return "MailSubmissionFailed";
    case 121: 
      return "MessageReplyFailed";
    case 122: 
      return "AttachmentIsTooLarge";
    case 123: 
      return "UserHasNoMailbox";
    case 124: 
      return "UserCannotBeAnonymous";
    case 125: 
      return "UserPrincipalCouldNotBeFound";
    case 126: 
      return "UserDisabledForSync";
    case 127: 
      return "UserOnNewMailboxCannotSync";
    case 128: 
      return "UserOnLegacyMailboxCannotSync";
    case 129: 
      return "DeviceIsBlockedForThisUser";
    case 130: 
      return "AccessDenied";
    case 131: 
      return "AccountDisabled";
    case 132: 
      return "SyncStateNotFound";
    case 133: 
      return "SyncStateLocked";
    case 134: 
      return "SyncStateCorrupt";
    case 135: 
      return "SyncStateAlreadyExists";
    case 136: 
      return "SyncStateVersionInvalid";
    case 137: 
      return "CommandNotSupported";
    case 138: 
      return "VersionNotSupported";
    case 139: 
      return "DeviceNotFullyProvisionable";
    case 140: 
      return "RemoteWipeRequested";
    case 141: 
      return "LegacyDeviceOnStrictPolicy";
    case 142: 
      return "DeviceNotProvisioned";
    case 143: 
      return "PolicyRefresh";
    case 144: 
      return "InvalidPolicyKey";
    case 145: 
      return "ExternallyManagedDevicesNotAllowed";
    case 146: 
      return "NoRecurrenceInCalendar";
    case 147: 
      return "UnexpectedItemClass";
    case 148: 
      return "RemoteServerHasNoSSL";
    case 149: 
      return "InvalidStoredRequest";
    case 150: 
      return "ItemNotFound";
    case 151: 
      return "TooManyFolders";
    case 152: 
      return "NoFoldersFound";
    case 153: 
      return "ItemsLostAfterMove";
    case 154: 
      return "FailureInMoveOperation";
    case 155: 
      return "MoveCommandDisallowedForNonPersistentMoveAction";
    case 156: 
      return "MoveCommandInvalidDestinationFolder";
    case 160: 
      return "AvailabilityTooManyRecipients";
    case 161: 
      return "AvailabilityDLLimitReached";
    case 162: 
      return "AvailabilityTransientFailure";
    case 163: 
      return "AvailabilityFailure";
    case 164: 
      return "BodyPartPreferenceTypeNotSupported";
    case 165: 
      return "DeviceInformationRequired";
    case 166: 
      return "InvalidAccountId";
    case 167: 
      return "AccountSendDisabled";
    case 168: 
      return "IRM_FeatureDisabled";
    case 169: 
      return "IRM_TransientError";
    case 170: 
      return "IRM_PermanentError";
    case 171: 
      return "IRM_InvalidTemplateID";
    case 172: 
      return "IRM_OperationNotPermitted";
    case 173: 
      return "NoPicture";
    case 174: 
      return "PictureTooLarge";
    case 175: 
      return "PictureLimitReached";
    case 176: 
      return "BodyPart_ConversationTooLarge";
    case 177: 
      return "MaximumDevicesReached";
    case 178: 
      return "InvalidMimeBodyCombination";
    case 179: 
      return "InvalidSmartForwardParameters";
    case 183: 
      return "InvalidRecipients";
    }
    return "OneOrMoreExceptionFailed";
  }
  
  public boolean isStatusOk()
  {
    switch (this.status)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
    case 96: 
    case 97: 
    case 98: 
    case 99: 
    case 100: 
    case 157: 
    case 158: 
    case 159: 
    case 180: 
    case 181: 
    case 182: 
    default: 
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus
 * JD-Core Version:    0.7.0.1
 */