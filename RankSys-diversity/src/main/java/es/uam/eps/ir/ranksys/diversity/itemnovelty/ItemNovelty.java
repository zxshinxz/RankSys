/* 
 * Copyright (C) 2014 Information Retrieval Group at Universidad Autonoma
 * de Madrid, http://ir.ii.uam.es
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.uam.eps.ir.ranksys.diversity.itemnovelty;

import es.uam.eps.ir.ranksys.core.model.UserModel;
import java.util.stream.Stream;

/**
 *
 * @author Saúl Vargas (saul.vargas@uam.es)
 * @author Pablo Castells (pablo.castells@uam.es)
 */
public abstract class ItemNovelty<U, I> extends UserModel<U> {

    public ItemNovelty(boolean caching, Stream<U> users) {
        super(caching, users);
    }

    public ItemNovelty() {
        super();
    }

    public ItemNovelty(Stream<U> users) {
        super(users);
    }

    @Override
    protected abstract UserItemNoveltyModel<U, I> get(U u);

    @SuppressWarnings("unchecked")
    @Override
    public UserItemNoveltyModel<U, I> getModel(U u) {
        return (UserItemNoveltyModel<U, I>) super.getModel(u);
    }

    public interface UserItemNoveltyModel<U, I> extends Model<U> {

        public double novelty(I i);
    }
}
