package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByUser(User user, Pageable pageable);

    /**
     * <p>
     *     select *
     *     from product p left join product_folder pf on p.id = pf.product_id
     *     where p.user_id = #{user.getId}
     *      and pf.folder_id = #{folderId}
     *     order by p.id #{pageable.?}
     *     limit #{pageable.?}, #{pageable.?}
     *
     * </p>
     * @param user 회원정보
     * @param folderId 폴더 ID
     * @param pageable 페이징
     * @return 페이징 된 상품 목록
     */
    Page<Product> findAllByUserAndProductFolderList_FolderId(User user, Long folderId, Pageable pageable);
}
