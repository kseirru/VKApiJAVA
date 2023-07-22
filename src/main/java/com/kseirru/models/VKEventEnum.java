package com.kseirru.models;

public enum VKEventEnum {
    MessageFlagEditEvent(1),
    MessageFlagSettingEvent(2),
    MessageFlagResetEvent(3),
    NewMessageReceivedEvent(4),
    MessageEditEvent(5),
    ReadAllIncomingMessagesEvent(6),
    ReadAllOutgoingMessagesEvent(7),
    UserIsOnlineEvent(8),
    UserIsOfflineEvent(9),
    DialogFlagResetEvent(10),
    DialogFlagEditEvent(11),
    DialogFlagSettingEvent(12),
    DeleteAllMessagesEvent(13),
    RecoveryAllMessagesEvent(14),
    MajorIdDialogChangedEvent(20),
    MinorIdDialogChanged(21),
    ChatSettingsEditEvent(51),
    ChatInfoEditEvent(52),
    UserDialogTypingEvent(61),
    UserChatTypingEvent(62),
    UsersChatTypingEvent(63),
    UsersChatVoiceMessageRecordingEvent(64),
    UserCallingEvent(70),
    IDontKnowWhatIsThis(80),
    NotifySettingsEditEvent(114);


    private final Integer eventId;

    VKEventEnum(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getValue() {
        return this.eventId;
    }

    // TODO: Сделать функцию, возвращающую VKEventEnum по eventId

    /*
    public static VKEventEnum getEvent(Integer eventId) {

    }
     */
}
