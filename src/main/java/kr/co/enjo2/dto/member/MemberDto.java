package kr.co.enjo2.dto.member;

public class MemberDto {
	private int memberNo;
	private String id;
	private String nickName;
	private String password;
	private String email;
	private String address;
	// enum 고려, user or admin
	private String memberType;
	
	public MemberDto() {}
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "MemberDto [memberNo=" + memberNo + ", id=" + id + ", nickName=" + nickName + ", password=" + password
				+ ", email=" + email + ", address=" + address + ", memberType=" + memberType + "]";
	}
}
