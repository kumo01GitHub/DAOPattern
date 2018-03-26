package dto;

public abstract class DTO {
	private Object key;

	public DTO(Object key) {
		this.key = key;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj.getClass() != this.getClass()) {
			return false;
		} else {
			return ((DTO) obj).getKey().equals(this.key);
		}
	}

}
