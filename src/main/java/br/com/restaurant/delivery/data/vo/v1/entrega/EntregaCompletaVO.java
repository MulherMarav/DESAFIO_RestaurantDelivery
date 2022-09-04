package br.com.restaurant.delivery.data.vo.v1.entrega;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import br.com.restaurant.delivery.data.vo.v1.pedido.PedidoVO;

public class EntregaCompletaVO extends RepresentationModel<EntregaCompletaVO>  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private LocalDateTime data;
	
	private String motoboy;
	
	private LocalDateTime valor;
	
    private List<PedidoVO> pedidos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(String motoboy) {
		this.motoboy = motoboy;
	}

	public LocalDateTime getValor() {
		return valor;
	}

	public void setValor(LocalDateTime valor) {
		this.valor = valor;
	}

	public List<PedidoVO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoVO> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id, motoboy, pedidos, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntregaCompletaVO other = (EntregaCompletaVO) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(motoboy, other.motoboy) && Objects.equals(pedidos, other.pedidos)
				&& Objects.equals(valor, other.valor);
	}
}