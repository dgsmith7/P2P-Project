
class ChatMessage {

    private String ownerId;
    private String content;

    public ChatMessage(String _ownerId, String _content) {
        this.ownerId = _ownerId;
        this.content = _content;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String _newOwnerId) {
        this.ownerId = _newOwnerId;
    }

    public String getContent() {
        return this.content;
    }

    public void setConent(String _newContent) {
        this.content = _newContent;
    }

}
