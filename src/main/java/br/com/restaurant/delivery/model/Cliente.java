package br.com.restaurant.delivery.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Column(unique = true)
	private String telefone;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_endereco")
	private Endereco endereco;

	private FormaPagamento formaPagamento;

	private LocalDateTime dataUltimoPedido;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	public Cliente() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public LocalDateTime getDataUltimoPedido() {
		return dataUltimoPedido;
	}

	public void setDataUltimoPedido(LocalDateTime dataUltimoPedido) {
		this.dataUltimoPedido = dataUltimoPedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataUltimoPedido, endereco, formaPagamento, id, nome, pedidos, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dataUltimoPedido, other.dataUltimoPedido) && Objects.equals(endereco, other.endereco)
				&& formaPagamento == other.formaPagamento && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(pedidos, other.pedidos)
				&& Objects.equals(telefone, other.telefone);
	}
}
